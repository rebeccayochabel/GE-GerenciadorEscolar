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

import br.com.gerenciadorescolar.ge.DTO.ServDto;
import br.com.gerenciadorescolar.ge.controllers.Firebase;

@Service
public class ServiceServImpl implements ServiceServ{

    @Autowired
    private Firebase firebase;
    
    @Override
    public List<ServDto> list() {
        List<ServDto> response = new ArrayList<>();
        ServDto serv;

        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection().get();
        try {
            for (DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
                serv = doc.toObject(ServDto.class);
                serv.setId(doc.getId());
                response.add(serv);
            }
            return response;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Boolean add(ServDto serv) {
        Map<String, Object> docData = getDocData(serv);											
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
    public Boolean edit(String id, ServDto serv) {
        Map<String, Object> docData = getDocData(serv);
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
	    		verificar = list().get(i).getNome().toLowerCase().contains(nome.toLowerCase());
	    		if(verificar==true) {
	    			achou =list().get(i).getId();
	    		}
	    	}
    	}
    	return achou;
    }

    private CollectionReference getCollection() {
        return firebase.getFirestore().collection("serv"); //nome da coleção
    }

    private Map<String, Object> getDocData(ServDto serv) {
        Map<String, Object> docData = new HashMap<>();

		docData.put("nome", serv.getNome());
        docData.put("cpf", serv.getCpf());
        docData.put("rg", serv.getRg());
        docData.put("sexo", serv.getSexo());
        docData.put("email", serv.getEmail());
        docData.put("tel", serv.getTel());
        docData.put("dtNasc", serv.getDtNasc());
        docData.put("funcao", serv.getFuncao());

        docData.put("tpSangue", serv.getTpSangue());
        docData.put("comorbidade", serv.getComorbidade());
        docData.put("qualCom", serv.getQualCom());

        docData.put("cep", serv.getCep());
        docData.put("rua", serv.getRua());
        docData.put("numCs", serv.getNumCs());
        docData.put("bairro", serv.getBairro());
        docData.put("complemento", serv.getComplemento());
        docData.put("cidade", serv.getCidade());
        docData.put("uf", serv.getUf());

        return docData;

    }

    
}
