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

import br.com.gerenciadorescolar.ge.DTO.ProfDto;
import br.com.gerenciadorescolar.ge.controllers.Firebase;

@Service
public class ServiceProfImpl implements ServiceProf{
    
    @Autowired
    private Firebase firebase;

    @Override
    public List<ProfDto> list() {
        List<ProfDto> response = new ArrayList<>();
        ProfDto prof;

        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection().get();
        try {
            for (DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
                prof = doc.toObject(ProfDto.class);
                prof.setId(doc.getId());
                response.add(prof);
            }
            return response;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Boolean add(ProfDto prof) {
        Map<String, Object> docData = getDocData(prof);											
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
    public Boolean edit(String id, ProfDto prof) {
        Map<String, Object> docData = getDocData(prof);
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
        return firebase.getFirestore().collection("prof"); //nome da coleção
    }
    
    private Map<String, Object> getDocData(ProfDto prof) {
        Map<String, Object> docData = new HashMap<>();

		docData.put("nome", prof.getNome());
        docData.put("cpf", prof.getCpf());
        docData.put("rg", prof.getRg());
        docData.put("sexo", prof.getSexo());
        docData.put("email", prof.getEmail());
        docData.put("tel", prof.getTel());
        docData.put("dtNasc", prof.getDtNasc());
        docData.put("formacao", prof.getFormacao());
        docData.put("materia", prof.getMateria());

        docData.put("tpSangue", prof.getTpSangue());
        docData.put("comorbidade", prof.getComorbidade());
        docData.put("qualCom", prof.getQualCom());

        docData.put("cep", prof.getCep());
        docData.put("rua", prof.getRua());
        docData.put("numCs", prof.getNumCs());
        docData.put("bairro", prof.getBairro());
        docData.put("complemento", prof.getComplemento());
        docData.put("cidade", prof.getCidade());
        docData.put("uf", prof.getUf());

        docData.put("dtCert", prof.getDtCert());

        return docData;

    }

}
