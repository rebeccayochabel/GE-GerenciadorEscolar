package br.com.gerenciadorescolar.ge.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

import br.com.gerenciadorescolar.ge.DTO.AtividadeDto;
import br.com.gerenciadorescolar.ge.controllers.Firebase;

@Service
public class ServiceAtvImpl implements ServiceAtv{

    @Autowired
    private Firebase firebase;

    @Override
    public List<AtividadeDto> list() {
        List<AtividadeDto> response = new ArrayList<>();
        AtividadeDto atividade;

        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection().get();
        try {
            for (DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
                atividade = doc.toObject(AtividadeDto.class);
                atividade.setId(doc.getId());
                response.add(atividade);
            }
            return response;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Boolean add(AtividadeDto atividade) {
        Map<String, Object> docData = getDocData(atividade);											
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document().create(docData);  

        try {
            if(null != writeResultApiFuture.get()){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean edit(String id, AtividadeDto atividade) {
        Map<String, Object> docData = getDocData(atividade);
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id).set(docData);
        try {
            if(null != writeResultApiFuture.get()){
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public Boolean delete(String id) {
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document(id).delete();
        try {
            if(null != writeResultApiFuture.get()){
                return Boolean.TRUE;
            }

        return Boolean.FALSE;
            } catch (Exception e) {
                return Boolean.FALSE;
            }
    }

    @Override
    public int buscarID(String id) {
    	boolean verificar;
    	int achou=0;
    	if(list().size() != 0) {
	    	for(int i=0; i<list().size(); i++) {
	    		verificar = list().get(i).getId().contains(id);
	    		if(verificar==true) {
	    			achou=i;
	    		}
	    	}
    	}
    	return achou;
    }

    @Override
    public String buscarIDPorNome(String nome) {
    	boolean verificar;
    	String achou=null;
    	if(list().size() != 0) {
	    	for(int i=0; i<list().size(); i++) {
	    		verificar = list().get(i).getAssunto().toLowerCase().contains(nome.toLowerCase());
	    		if(verificar==true) {
	    			achou =list().get(i).getId();
	    		}
	    	}
    	}
    	return achou;
    }

    private CollectionReference getCollection() {
        return firebase.getFirestore().collection("atividade"); //nome da coleção
    }

    private Map<String, Object> getDocData(AtividadeDto atividade) {
        Map<String, Object> docData = new HashMap<>();

		docData.put("assunto", atividade.getAssunto());
        docData.put("valorAtv", atividade.getValorAtv());
        docData.put("orientacoes", atividade.getOrientacoes());
        docData.put("dtEntrega", atividade.getDtEntrega());
        docData.put("hrEntrega", atividade.getHrEntrega());
        docData.put("turma", atividade.getTurma());

        return docData;

    }
    
}
