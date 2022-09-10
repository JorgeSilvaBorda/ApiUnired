package unired.api.rendiciones;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProcesoMapper {

    @Select(Querys.PROGRAMADO_DIA_FERIADO)
    Integer getProgramadosDiaFeriado();
    
    @Select(Querys.PROGRAMADO_DIA_FERIADO_ANTERIOR_NORMAL)
    Integer getProgramadosDiaFeriadoAnteriorNormal();

    @Select(Querys.PROGRAMADO_DIA_POSTFERIADO)
    Integer getProgramadosDiaPostFeriado();

    @Select(Querys.PROGRAMADO_DIA_NORMAL)
    Integer getProgramadosDiaNormal();

    @Select(Querys.CUENTA_ESTADOS)
    Procesos getCuentaProcesos();

    @Select(Querys.PROCESOS_DIA_FERIADO)
    List<ProcesoProgramado> getProcesosDiaFeriado();
    
    @Select(Querys.PROCESOS_DIA_FERIADO_ANTERIOR_NORMAL)
    List<ProcesoProgramado> getProcesosDiaFeriadoAnteriorNormal();

    @Select(Querys.PROCESOS_DIA_NORMAL)
    List<ProcesoProgramado> getProcesosDiaNormal();

    @Select(Querys.PROCESOS_DIA_POSTFERIADO)
    List<ProcesoProgramado> getProcesosDiaPostferiado();

    @Select(Querys.EJECUTADOS)
    List<Proceso> getProcesosDiaEjecutados();

    @Select(Querys.EXITOSOS)
    List<Proceso> getProcesosDiaExitosos();

    @Select(Querys.ERRORES)
    List<Proceso> getProcesosDiaErrores();

    @Select(Querys.PENDIENTES)
    List<Proceso> getProcesosDiaPendientes();

    @Select(Querys.ENVIADOS_MAIL)
    List<Proceso> getProcesosDiaEnviadoMail();

    @Select(Querys.RENDICION_VACIA)
    List<Proceso> getProcesosRendicionVacia();

    @Select(Querys.GENERADOS)
    List<Proceso> getProcesosGenerados();

    @Select(Querys.TRANSMITIDOS)
    List<Proceso> getProcesosTransmitidos();

    @Select(Querys.EN_EJECUCION)
    List<Proceso> getProcesosRendicionEjecucion();

    @Select(Querys.SUB_PROCESOS)
    List<SubProceso> getSubProcesosIdProceso(Integer idProceso);

}
