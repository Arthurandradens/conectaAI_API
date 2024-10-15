package br.com.spring.conectaAI.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GenericMapper <O,D>{

    private static final ModelMapper modelMapper = new ModelMapper();

    public static <O,D> D convertObjectToDestiny(O object, Class<D> destiny){
        return modelMapper.map(object, destiny);
    }

    public List<D> convertObjectToListDestiny(List<O> object, Class<D> destiny){
        return object.stream()
                .map(o -> modelMapper.map(o,destiny))
                .collect(Collectors.toList());
    }
}