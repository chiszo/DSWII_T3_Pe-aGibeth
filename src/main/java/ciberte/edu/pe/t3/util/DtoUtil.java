package ciberte.edu.pe.t3.util;

import ciberte.edu.pe.t3.model.dto.DtoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DtoUtil {
    public DtoEntity convertirADto(Object obj, DtoEntity mapper){
        return new ModelMapper().map(obj, mapper.getClass());
    }

    public Object convertirDtoAEntity (Object obj, DtoEntity mapper){
        return new ModelMapper().map(mapper,obj.getClass());
    }
}
