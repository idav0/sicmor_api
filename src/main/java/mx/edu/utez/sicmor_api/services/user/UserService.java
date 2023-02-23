package mx.edu.utez.sicmor_api.services.user;

import mx.edu.utez.sicmor_api.models.history.History;
import mx.edu.utez.sicmor_api.models.user.User;
import mx.edu.utez.sicmor_api.models.user.UserRepository;
import mx.edu.utez.sicmor_api.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class UserService {

   @Autowired
   private UserRepository repository;


    @Transactional(readOnly = true)
    public Response<User> getOne(Long id){
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
    public Response<User> update (User user) {

        if (!this.repository.existsById(user.getId()))
            return new Response<>(
                    null,
                    true,
                    400,
                    "El registro no se encontró"
            );

        return new Response<>(
                this.repository.saveAndFlush(user),
                false,
                200,
                "Registro actualizado correctamente"
        );
    }

}
