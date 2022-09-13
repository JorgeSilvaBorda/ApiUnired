package unired.api.nominas;

import io.quarkiverse.mybatis.runtime.meta.MapperDataSource;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
@MapperDataSource("nominas")
public interface ProcesoNominasMapper {

    @Select(Querys.RESUMEN_NOMINAS)
    ProcesosNomina getResumenNominas();
    
    @Select(Querys.QUERY_PROGRAMADAS)
    List<ProcesoNomina> getProgramadas();
    
    @Select(Querys.QUERY_EJECUTADOS)
    List<ProcesoNomina> getEjecutadas();
    
    @Select(Querys.QUERY_EXITOSAS)
    List<ProcesoNomina> getExitosas();
    
    @Select(Querys.QUERY_ERRORES)
    List<ProcesoNomina> getErrores();
    
    @Select(Querys.QUERY_PENDIENTES)
    List<ProcesoNomina> getPendientes();
    
    @Select(Querys.QUERY_NO_RECIBIDAS)
    List<ProcesoNomina> getNoRecibidas();
    
    @Select(Querys.QUERY_SIN_PROCESAR)
    List<ProcesoNomina> getSinProcesar();
    
    @Select(Querys.QUERY_PARCIALMENTE)
    List<ProcesoNomina> getParcialmente();
    
    @Select(Querys.QUERY_NO_CUMPLE)
    List<ProcesoNomina> getNoCumple();
    
    @Select(Querys.HISTORIA)
    List<ProcesoNomina> getNominasHistoria(String fechaIni, String fechaFin);
}
