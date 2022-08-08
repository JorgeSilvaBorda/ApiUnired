package unired.api.rendiciones;

import java.time.LocalDate;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProcesoMapper {

    final String QUERY_CUENTA_PROCESOS = "SELECT\n"
	    + "	SUM(CASE WHEN EstadoProceso = 56 THEN 1 ELSE 0 END) enEspera,\n"
	    + "    SUM(CASE WHEN EstadoProceso = 25 THEN 1 ELSE 0 END) pendiente,\n"
	    + "    SUM(CASE WHEN EstadoProceso = 26 THEN 1 ELSE 0 END) enEjecucion,\n"
	    + "    SUM(CASE WHEN EstadoProceso = 27 THEN 1 ELSE 0 END) generado,\n"
	    + "    SUM(CASE WHEN EstadoProceso = 28 THEN 1 ELSE 0 END) transmitido,\n"
	    + "    SUM(CASE WHEN EstadoProceso = 29 THEN 1 ELSE 0 END) fallaEnProceso,\n"
	    + "    SUM(CASE WHEN EstadoProceso = 40 THEN 1 ELSE 0 END) enviadoAMail,\n"
	    + "    SUM(CASE WHEN EstadoProceso = 4046 THEN 1 ELSE 0 END) rendicionVacia,\n"
	    + "    SUM(CASE WHEN EstadoProceso IN(27, 40, 4046) THEN 1 END) exitoso,\n"
	    + "    COUNT(IdProceso) total\n"
	    + "FROM\n"
	    + "	Procesos\n"
	    + "WHERE\n"
	    + " (CONVERT(DATE, FechaCreacion) = CONVERT(DATE, GETDATE()) AND EstadoProceso != 56)"
	    + " OR"
	    + " (EstadoProceso = 56 AND CONVERT(DATE, FechaCreacion) = CONVERT(DATE, DATEADD(DAY, -1, GETDATE())))"
	    + "";

    final String QUERY_PROCESO_UNICO = "SELECT\n"
	    + "    a.IdProceso,\n"
	    + "    a.IdEmpresa,\n"
	    + "    b.NombreEps,\n"
	    + "    a.EstadoProceso CodEstado,\n"
	    + "    CASE\n"
	    + "    	WHEN a.EstadoProceso = 56 THEN 'En Espera'\n"
	    + "        WHEN a.EstadoProceso = 25 THEN 'Pendiente'\n"
	    + "        WHEN a.EstadoProceso = 26 THEN 'En Ejecución'\n"
	    + "        WHEN a.EstadoProceso = 27 THEN 'Generado'\n"
	    + "        WHEN a.EstadoProceso = 28 THEN 'Transmitido'\n"
	    + "        WHEN a.EstadoProceso = 29 THEN 'Falla en el Proceso'\n"
	    + "        WHEN a.EstadoProceso = 40 THEN 'Enviado a Mail'\n"
	    + "        WHEN a.EstadoProceso = 4046 THEN 'Rendición Vacía'\n"
	    + "    END AS Estado,\n"
	    + "    a.FechaProceso,\n"
	    + "    a.FechaCreacion,\n"
	    + "    a.InicioProceso,\n"
	    + "    a.FinProceso\n"
	    + "FROM\n"
	    + "	Procesos a inner join Empresas b\n"
	    + "    on a.IdEmpresa = b.IdEmpresa\n"
	    + "WHERE\n"
	    + " ((CONVERT(DATE, a.FechaCreacion) = CONVERT(DATE, GETDATE()) AND a.EstadoProceso != 56)"
	    + " OR"
	    + " (a.EstadoProceso = 56 AND CONVERT(DATE, a.FechaCreacion) = CONVERT(DATE, DATEADD(DAY, -1, GETDATE()))))"
	    + " and a.IdProceso = #{idProceso}\n"
	    + "order by\n"
	    + "	a.FechaCreacion DESC";

    final String QUERY_SUB_PROCESOS = "SELECT\n"
	    + "	IdBitacora,\n"
	    + "    Descripcion,\n"
	    + "    EventosProceso,\n"
	    + "    FechaCreacion,\n"
	    + "    Procesos_IdProceso\n"
	    + "FROM\n"
	    + "	BitacoraProcesos\n"
	    + "WHERE\n"
	    + "	Procesos_IdProceso = #{idProceso}\n"
	    + "ORDER BY\n"
	    + "	IdBitacora ASC";
    
    @Select("SELECT * FROM Procesos a inner join Empresas b on a.IdEmpresa = b.IdEmpresa WHERE IdProceso = #{idProceso}")
    Proceso getProceso(Integer idProceso);

    @Select("SELECT COUNT(IdProceso) CANT FROM Procesos WHERE (CONVERT(DATE, FechaCreacion) = CONVERT(DATE, GETDATE()) AND EstadoProceso != 56) OR (EstadoProceso = 56 AND CONVERT(DATE, FechaCreacion) = CONVERT(DATE, DATEADD(DAY, -1, GETDATE())))")
    Integer getProcesosActivos();

    @Select(QUERY_CUENTA_PROCESOS)
    Procesos getCuentaProcesos();

    @Select("SELECT * FROM Procesos a inner join Empresas b on a.IdEmpresa = b.IdEmpresa WHERE ((CONVERT(DATE, FechaCreacion) = CONVERT(DATE, GETDATE()) AND EstadoProceso != 56) OR (EstadoProceso = 56 AND CONVERT(DATE, FechaCreacion) = CONVERT(DATE, DATEADD(DAY, -1, GETDATE())))) ORDER BY IDPROCESO ASC")
    List<Proceso> getProcesosDia();

    @Select("SELECT * FROM Procesos a inner join Empresas b on a.IdEmpresa = b.IdEmpresa WHERE ((CONVERT(DATE, FechaCreacion) = CONVERT(DATE, GETDATE()) AND EstadoProceso != 56) OR (EstadoProceso = 56 AND CONVERT(DATE, FechaCreacion) = CONVERT(DATE, DATEADD(DAY, -1, GETDATE())))) AND EstadoProceso = #{codEstado} ORDER BY IDPROCESO ASC")
    List<Proceso> getProcesosDiaCodEstado(Integer codEstado);
    
    @Select("SELECT * FROM Procesos a inner join Empresas b on a.IdEmpresa = b.IdEmpresa WHERE ((CONVERT(DATE, FechaCreacion) = CONVERT(DATE, GETDATE()) AND EstadoProceso != 56) OR (EstadoProceso = 56 AND CONVERT(DATE, FechaCreacion) = CONVERT(DATE, DATEADD(DAY, -1, GETDATE())))) AND EstadoProceso in(27,28,29,40,4046) ORDER BY IDPROCESO ASC")
    List<Proceso> getProcesosDiaEjecutados();
    
    @Select("SELECT * FROM Procesos a inner join Empresas b on a.IdEmpresa = b.IdEmpresa WHERE ((CONVERT(DATE, FechaCreacion) = CONVERT(DATE, GETDATE()) AND EstadoProceso != 56) OR (EstadoProceso = 56 AND CONVERT(DATE, FechaCreacion) = CONVERT(DATE, DATEADD(DAY, -1, GETDATE())))) AND EstadoProceso in(27,40,4046) ORDER BY IDPROCESO ASC")
    List<Proceso> getProcesosDiaExitosos();
    
    @Select("SELECT * FROM Procesos a inner join Empresas b on a.IdEmpresa = b.IdEmpresa WHERE ((CONVERT(DATE, FechaCreacion) = CONVERT(DATE, GETDATE()) AND EstadoProceso != 56) OR (EstadoProceso = 56 AND CONVERT(DATE, FechaCreacion) = CONVERT(DATE, DATEADD(DAY, -1, GETDATE())))) AND EstadoProceso = 29 ORDER BY IDPROCESO ASC")
    List<Proceso> getProcesosDiaErrores();
    
    @Select("SELECT * FROM Procesos a inner join Empresas b on a.IdEmpresa = b.IdEmpresa WHERE (CONVERT(DATE, FechaCreacion) = CONVERT(DATE, GETDATE()) AND EstadoProceso != 56) OR (EstadoProceso = 56 AND CONVERT(DATE, FechaCreacion) = CONVERT(DATE, DATEADD(DAY, -1, GETDATE()))) AND EstadoProceso = 56 ORDER BY IDPROCESO ASC")
    List<Proceso> getProcesosDiaPendientes();

    @Select(QUERY_SUB_PROCESOS)
    List<SubProceso> getSubProcesosIdProceso(Integer idProceso);


}
