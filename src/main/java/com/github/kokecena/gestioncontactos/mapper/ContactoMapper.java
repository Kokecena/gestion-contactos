package com.github.kokecena.gestioncontactos.mapper;

import com.github.kokecena.gestioncontactos.entity.Contacto;
import com.github.kokecena.gestioncontactos.model.ContactoDTO;
import com.github.kokecena.gestioncontactos.model.ContactoResponse;
import com.github.kokecena.gestioncontactos.model.InformacionDTO;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.springframework.util.StringUtils;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ContactoMapper {
    @Mapping(target = "telefono", source = "numTelefono")
    @Mapping(target = "direccion.numero", source = "direccion.numInterno")
    @Mapping(target = "direccion.numeroExterno", source = "direccion.numExterno")
    ContactoDTO toDto(Contacto contacto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "numTelefono", source = "telefono")
    @Mapping(target = "direccion.numInterno", source = "direccion.numero")
    @Mapping(target = "direccion.numExterno", source = "direccion.numeroExterno")
    Contacto toEntity(ContactoDTO contactoDto);

    @Mapping(target = "nombre", source = "informacion", qualifiedByName = "InformacionToString")
    ContactoResponse toResponse(ContactoDTO contactoDTO);

    @Named("InformacionToString")
    default String composeContactName(InformacionDTO informacion) {
        StringBuilder sb = new StringBuilder(informacion.getNombre());
        if (StringUtils.hasText(informacion.getApellido())) {
            sb.append(" ").append(informacion.getApellido());
        }
        if (StringUtils.hasText(informacion.getAlias())) {
            sb.append(" (").append(informacion.getAlias()).append(")");
        }
        return sb.toString();
    }
}