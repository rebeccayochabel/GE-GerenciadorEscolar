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

import br.com.gerenciadorescolar.ge.DTO.AlunoDto;
import br.com.gerenciadorescolar.ge.controllers.Firebase;

@Service
public class ServiceAlunoImpl implements ServiceAluno {

    @Autowired
    private Firebase firebase;

    @Override
    public List<AlunoDto> list() {
        List<AlunoDto> response = new ArrayList<>();
        AlunoDto aluno;

        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection().get();
        try {
            for (DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
                aluno = doc.toObject(AlunoDto.class);
                aluno.setId(doc.getId());
                response.add(aluno);
            }
            return response;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Boolean add(AlunoDto aluno) {
    	
        Map<String, Object> docData = getDocData(aluno);											// Vai criar um mapa para armazenar os dados do paciente
        ApiFuture<WriteResult> writeResultApiFuture = getCollection().document().create(docData);  // Vai adicionar um novo documento (de forma assíncrona) na coleção do getCollection com id

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
    public Boolean edit(String id, AlunoDto aluno) {
        Map<String, Object> docData = getDocData(aluno);
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
        return firebase.getFirestore().collection("aluno"); //nome da coleção
    }
    
    private Map<String, Object> getDocData(AlunoDto aluno) {
        Map<String, Object> docData = new HashMap<>();
        docData.put("nome", aluno.getNome());
        docData.put("cpf", aluno.getCpf());
        docData.put("rg", aluno.getRg());
        docData.put("sexo", aluno.getSexo());
        docData.put("email", aluno.getEmail());
        docData.put("tel", aluno.getTel());
        docData.put("dtNasc", aluno.getDtNasc());
        docData.put("turma", aluno.getTurma());
        
        docData.put("tpSangue", aluno.getTpSangue());
        docData.put("comorbidade", aluno.getComorbidade());
        docData.put("qualCom", aluno.getQualCom());
        
        docData.put("cep", aluno.getCep());
        docData.put("rua", aluno.getRua());
        docData.put("numCs", aluno.getNumCs());
        docData.put("bairro", aluno.getBairro());
        docData.put("complemento", aluno.getComplemento());
        docData.put("cidade", aluno.getCidade());
        docData.put("uf", aluno.getUf());
        
        docData.put("nomeResp", aluno.getNomeResp());
        docData.put("emailResp", aluno.getEmailResp());
        docData.put("telResp", aluno.getTelResp());
        
        return docData;
    }
}

