package com.ancient.emodecrypt.service;

import com.ancient.emodecrypt.entity.MassaDadosEntity;
import com.ancient.emodecrypt.repository.MassaDadosRepository;
import com.ancient.emodecrypt.request.MassaDadosRequest;
import com.ancient.emodecrypt.response.MassaDadosResponse;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.bson.types.ObjectId;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MassaDadosService {
    @Autowired
    private MassaDadosRepository massaDadosRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private OpenAiChatClient gpt;

    public MassaDadosResponse create(MassaDadosRequest massaDadosRequest) {

        List<String> emocoes = getEmocoes(massaDadosRequest.comentario());
        Integer nivelSatisfacao = getSatisfacao(massaDadosRequest.comentario());
        List<String> palavrasChave = getPalavrasChave(massaDadosRequest.comentario());

        MassaDadosEntity massaDados = MassaDadosEntity.builder()
                .nome(massaDadosRequest.nome())
                .comentario(massaDadosRequest.comentario())
                .qtdCurtidas(massaDadosRequest.qtdCurtidas())
                .nivelSatisfacao(nivelSatisfacao)
                .palavrasChaves(palavrasChave)
                .tipoMassa(massaDadosRequest.tipoMassa())
                .plataformaOrigem(massaDadosRequest.plataformaOrigem())
                .empresa(massaDadosRequest.empresa())
                .dataPublicacao(massaDadosRequest.dataPublicacao())
                .dataCriacao(LocalDate.now())
                .emocaoTransmitida(emocoes)
                .palavrasChaves(palavrasChave)
                .build();

            massaDadosRepository.save(massaDados);

        return new MassaDadosResponse(massaDados);
    }

    private List<String> getPalavrasChave(String comentario) {
        String palavraChave = gpt.call("qual as palavras chaves que a mensagem " + comentario + " transmite. retonar apena a lista dos sentimentos separado por virgula");
        List<String> palavrasChave = new ArrayList<>();
        System.out.println(palavraChave);
        palavrasChave.addAll(List.of(palavraChave.split(", ")));
        return palavrasChave;
    }

    private Integer getSatisfacao(String comentario) {
        Integer satisfacao = Integer.valueOf(gpt.call("calcule o nivel de satisfação preciso do cliente com base no comentario '" + comentario + "' e nos sentimentos que ele transmite. RETORNAR APENAS O VALOR de 0 a 100"));
        return satisfacao;
    }
    public List<MassaDadosResponse> createAll(List<MassaDadosRequest> massaDadosRequests) {
        List<MassaDadosResponse> responses = new ArrayList<>();
        for (MassaDadosRequest request : massaDadosRequests) {
            responses.add(create(request));
        }
        return responses;
    }
    public List<String> getEmocoes(String comentario){
        String emocao = gpt.call("qual sentimento a mensagem " + comentario + " transmite. retonar apena a lista dos sentimentos");
        List<String> emocoes = new ArrayList<>();
        emocoes.addAll(List.of(emocao.split(", ")));

        return emocoes;
    }

    public MassaDadosResponse findById(ObjectId id) {
        var optional = massaDadosRepository.findById(id);

        var massaDados = MassaDadosEntity.builder()
                .tipoMassa(optional.get().getTipoMassa())
                .plataformaOrigem(optional.get().getPlataformaOrigem())
                .palavrasChaves(optional.get().getPalavrasChaves())
                .nivelSatisfacao(optional.get().getNivelSatisfacao())
                .comentario(optional.get().getComentario())
                .id(optional.get().getId())
                .nome(optional.get().getNome())
                .dataCriacao(optional.get().getDataCriacao())
                .dataPublicacao(optional.get().getDataPublicacao())
                .qtdCurtidas(optional.get().getQtdCurtidas())
                .emocaoTransmitida(optional.get().getEmocaoTransmitida())
                .palavrasChaves(optional.get().getPalavrasChaves())
                .build();
        return new MassaDadosResponse(massaDados);
    }

    public List<MassaDadosResponse> findAll() {
        List<MassaDadosEntity> massaDadosEntityList = massaDadosRepository.findAll();
        List<MassaDadosResponse> massaDadosResponse = new ArrayList<>();
        massaDadosEntityList.stream().map(m -> massaDadosResponse.add(new MassaDadosResponse(m))).collect(Collectors.toList());
        return massaDadosResponse;
    }
    public List<MassaDadosResponse> getByNomeEmpresa(String empresa) {
        List<MassaDadosEntity> massaDadosEntityList = massaDadosRepository.findByEmpresa(empresa);
        List<MassaDadosResponse> massaDadosResponse = new ArrayList<>();
        massaDadosEntityList.stream().map(m -> massaDadosResponse.add(new MassaDadosResponse(m))).collect(Collectors.toList());
        return massaDadosResponse;
    }

    public Double calcularMediaSatisfacao(String empresa) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("empresa").is(empresa)),
                Aggregation.group("empresa").avg("nivelSatisfacao").as("averageSatisfaction")
        );

        AggregationResults<Map> result = mongoTemplate.aggregate(aggregation, "massa_dados", Map.class);
        Double average = (Double) result.getUniqueMappedResult().get("averageSatisfaction");

        return average != null ? BigDecimal.valueOf(average).setScale(2, RoundingMode.HALF_UP).doubleValue() : null;
    }

//    public List<MassaDadosResponse> createAll(List<MassaDadosRequest> massaDadosRequestList) {
//        List<MassaDadosEntity> massaDados = massaDadosRequestList.stream()
//                .map(request -> MassaDadosEntity.builder()
//                        .empresa(request.empresa())
//                        .qtdCurtidas(request.qtdCurtidas())
//                        .tipoMassa(request.tipoMassa())
//                        .nome(request.nome())
//                        .plataformaOrigem(request.plataformaOrigem())
//                        .comentario(request.comentario())
//                        .dataPublicacao(request.dataPublicacao())
//                        .build())
//                .collect(Collectors.toList());
//        List<MassaDadosEntity> savedEntities = massaDadosRepository.saveAll(massaDados);
//
//        return savedEntities.stream()
//                .map(entity -> new MassaDadosResponse(entity))
//                .collect(Collectors.toList());
//    }

}
