package mx.edu.utez.sicmor_api.services.history;

import mx.edu.utez.sicmor_api.models.history.History;
import mx.edu.utez.sicmor_api.models.history.HistoryRepository;
import mx.edu.utez.sicmor_api.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HistoryService {


    @Autowired
    private HistoryRepository repository;

    @Transactional(readOnly = true)
    public Response<List<History>> getAll(){
        return new Response<>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }

    @Transactional(readOnly = true)
    public Response<History> getOne(Long id){
        if(this.repository.existsById(id)){
            return new Response<>(
                    this.repository.findById(id).get(),
                    false,
                    200,
                    "OK"
            );
        }
        return new Response<>(
                null,
                true,
                400,
                "El registro no se encontró"
        );

    }


    @Transactional(rollbackFor = {SQLException.class})
    public Response<History> insert (History history){

        Optional<History> exists = this.repository.findById(history.getId()!=null?history.getId():0L);
        if(exists.isPresent())
            return new Response<>(
                    null,
                    true,
                    400,
                    "El registro ya se encuentra registrada"
            );

        return new Response<>(
                this.repository.saveAndFlush(history),
                false,
                200,
                "Registro ingresado correctamente"
        );


    }


}
