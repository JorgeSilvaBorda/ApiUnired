package unired.api.extract;

public class Querys {

    public static final String EXTRACT_DIA_ACTUAL = ""
            + "SELECT \n"
            + "	A.IdLogSistema IDLOGSISTEMA,\n"
            + " A.IdEmpresa IDEMPRESA,\n"
            + " 'EXTRACT' AS CODEMPRESA,\n"
            + "	'EXTRACT' AS NOMBREEPS,\n"
            + "	A.FechaCreacion FECHAHORACREACION,\n"
            + "	CONVERT(DATE, A.FechaCreacion) FECHACREACION,\n"
            + "	CONVERT(VARCHAR, A.FechaCreacion, 8) HORACREACION, \n"
            + "	A.TipoLog_IdTipo IDTIPOLOG,\n"
            + "	B.Descripcion DESCRIPCIONLOG\n"
            + "FROM\n"
            + "	LogEventosSistema A INNER JOIN TipoLog B\n"
            + "	ON A.TipoLog_IdTipo  = B.IdTipo \n"
            + "WHERE \n"
            + "	(A.IdEmpresa  = 'EXTRAC') \n"
            + "	AND CONVERT(DATE, A.FechaCreacion) = CONVERT(DATE, GETDATE())\n"
            + "	AND A.FechaCreacion <= CONVERT(DATETIME, (CONVERT(VARCHAR, CONVERT(DATE, GETDATE())) + ' 02:25:59.999'))\n"
            + "	AND A.FechaCreacion >= CONVERT(DATETIME, (CONVERT(VARCHAR, CONVERT(DATE, GETDATE())) + ' 02:20:00.000'))\n"
            + "ORDER BY\n"
            + "	A.FechaCreacion ASC ";

}
