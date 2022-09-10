package unired.api.rendiciones;

import io.quarkiverse.mybatis.runtime.meta.MapperDataSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
@MapperDataSource("nominas")
public interface ProcesoNominasMapper {

    @Select(Querys.RESUMEN_NOMINAS)
    ProcesosNomina getResumenNominas();
}
