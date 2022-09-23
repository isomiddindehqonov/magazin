package imtixon.mapper;

import imtixon.dto.UnitsDto;
import imtixon.entity.Units;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UnitsMapper {
    Units toEntity(UnitsDto unitsDto);
    UnitsDto toDto(Units units);
}
