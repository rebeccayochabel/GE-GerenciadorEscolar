package br.com.gerenciadorescolar.ge.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gerenciadorescolar.ge.DTO.JogoDto;
import br.com.gerenciadorescolar.ge.controllers.Firebase;

@Service
public class ServiceJogoImpl implements  ServiceJogo{

    @Autowired
    private Firebase firebase;

    @Override
    public List<JogoDto> list() {
        List<JogoDto> response = new ArrayList<>();
        JogoDto jogo;

        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection().get();
        try {
            for (DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
                jogo = doc.toObject(JogoDto.class);
                jogo.setId(doc.getId());
                response.add(jogo);
            }
            return response;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Boolean add(JogoDto jogo) {
        Map<String, Object> docData = getDocData(jogo);											
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
    public Boolean edit(String id, JogoDto jogo) {
        Map<String, Object> docData = getDocData(jogo);
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
	    		verificar = list().get(i).getModalidade().toLowerCase().contains(nome.toLowerCase());
	    		if(verificar==true) {
	    			achou =list().get(i).getId();
	    		}
	    	}
    	}
    	return achou;
    }

    private CollectionReference getCollection() {
        return firebase.getFirestore().collection("jogo"); //nome da coleção
    }

    private Map<String, Object> getDocData(JogoDto jogo) {
        Map<String, Object> docData = new HashMap<>();

		docData.put("modalidade", jogo.getModalidade());
        docData.put("dtJogo", jogo.getDtJogo());
        docData.put("hrJogo", jogo.getHrJogo());
        docData.put("informacoes", jogo.getInformacoes());
        
        return docData;

    }


    
    
}
