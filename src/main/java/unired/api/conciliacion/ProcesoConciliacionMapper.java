package unired.api.conciliacion;

import io.quarkiverse.mybatis.runtime.meta.MapperDataSource;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
@MapperDataSource("conciliacion")
public interface ProcesoConciliacionMapper {

    @Select(Querys.CONCILIACION_FECHA_ACTUAL)
    List<ProcesoConciliacion> getConciliacionDiaActual();

    @Select(Querys.HISTORIC_CONCILIACION)
    List<ProcesoConciliacionCompleto> getHistoricoConciliacion(String fechaIni, String fechaFin);

}
