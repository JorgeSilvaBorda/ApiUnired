package unired.api.extract;

public class Querys {

    public static final String EXTRACT_FECHA_ACTUA = ""
            + "SELECT \n"
            + "	A.IdLogSistema IDLOGSISTEMA,\n"
            + "	A.IdEmpresa IDEMPRESA,\n"
            + "	C.NombreEps AS NOMBREEPS,\n"
            + "	A.FechaCreacion FECHAHORACREACION,\n"
            + "	CONVERT(DATE, A.FechaCreacion) FECHACREACION,\n"
            + "	CONVERT(VARCHAR, A.FechaCreacion, 8) HORACREACION, \n"
            + "	A.TipoLog_IdTipo IDTIPOLOG,\n"
            + "	B.Descripcion DESCRIPCIONLOG\n"
            + "FROM\n"
            + "	LogEventosSistema A INNER JOIN TipoLog B\n"
            + "	ON A.TipoLog_IdTipo  = B.IdTipo INNER JOIN EmpresaProceso C\n"
            + "	ON A.IdEmpresa = C.IdEmpresa \n"
            + "WHERE \n"
            + "	(A.IdEmpresa  = 'EXTRAC') \n"
            + "	AND CONVERT(DATE, A.FechaCreacion) = CONVERT(DATE, GETDATE())\n"
            + "	AND A.FechaCreacion <= CONVERT(DATETIME, (CONVERT(VARCHAR, CONVERT(DATE, GETDATE())) + ' 02:25:59.999'))\n"
            + "	AND A.FechaCreacion >= CONVERT(DATETIME, (CONVERT(VARCHAR, CONVERT(DATE, GETDATE())) + ' 02:20:00.000'))\n"
            + "ORDER BY\n"
            + "	A.FechaCreacion ASC ";

    public static final String HISTORIA_EXTRACT = ""
            + "SELECT \n"
            + "	A.IDEMPRESA,\n"
            + "	C.NombreEps NOMBREEPS,\n"
            + "	A.FECHAPROCESO,\n"
            + "	A.FECHAPROCESOINI FECHAHORAINIPROCESO,\n"
            + "	A.HORAPROCESOINI HORAINIPROCESO,\n"
            + "	A.IDTIPOLOGINI IDESTADOINIPROCESO,\n"
            + "	A.DESCINI DESCESTADOINIPROCESO,\n"
            + "	B.FECHAPROCESOFIN FECHAHORAFINPROCESO,\n"
            + "	B.HORAPROCESOFIN HORAFINPROCESO,\n"
            + "	B.IDTIPOLOGFIN IDESTADOFINPROCESO,\n"
            + "	B.DESCFIN DESCESTADOFINPROCESO\n"
            + "FROM \n"
            + "	(\n"
            + "	SELECT \n"
            + "		A.IdEmpresa IDEMPRESA,\n"
            + "		A.TipoLog_IdTipo IDTIPOLOGINI,\n"
            + "		C.Descripcion DESCINI,\n"
            + "		B.*\n"
            + "	FROM 	\n"
            + "		LogEventosSistema A INNER JOIN (\n"
            + "			SELECT \n"
            + "				CONVERT(DATE, A.FechaCreacion) FECHAPROCESO,\n"
            + "				MIN(A.FechaCreacion) FECHAPROCESOINI,\n"
            + "				CONVERT(VARCHAR, MIN(A.FechaCreacion), 8) HORAPROCESOINI\n"
            + "			FROM\n"
            + "				LogEventosSistema A INNER JOIN TipoLog B\n"
            + "				ON A.TipoLog_IdTipo  = B.IdTipo \n"
            + "			WHERE \n"
            + "				(A.IdEmpresa  = 'EXTRAC') \n"
            + "				AND (CONVERT(DATE, A.FechaCreacion) BETWEEN '${fechaIni}' AND '${fechaFin}')\n"
            + "				AND (DATEPART(HOUR, A.FechaCreacion) >= 2 AND DATEPART(MINUTE, A.FechaCreacion) >=20) \n"
            + "				AND (DATEPART(HOUR, A.FechaCreacion) <= 2 AND DATEPART(MINUTE, A.FechaCreacion) <=25 AND DATEPART(SECOND, A.FechaCreacion) <= 59)\n"
            + "			GROUP BY \n"
            + "				CONVERT(DATE, A.FechaCreacion)\n"
            + "		) B\n"
            + "		ON A.FechaCreacion = B.FECHAPROCESOINI \n"
            + "		AND CONVERT(DATE, A.FechaCreacion) = B.FECHAPROCESO INNER JOIN TipoLog C\n"
            + "		ON A.TipoLog_IdTipo  = C.IdTipo\n"
            + "	) A INNER JOIN (\n"
            + "			SELECT \n"
            + "				A.TipoLog_IdTipo IDTIPOLOGFIN,\n"
            + "				C.Descripcion DESCFIN,\n"
            + "				B.*\n"
            + "			FROM 	\n"
            + "				LogEventosSistema A INNER JOIN (\n"
            + "				SELECT \n"
            + "					CONVERT(DATE, A.FechaCreacion) FECHAPROCESO,\n"
            + "					MAX(A.FechaCreacion) FECHAPROCESOFIN,\n"
            + "					CONVERT(VARCHAR, MAX(A.FechaCreacion), 8) HORAPROCESOFIN\n"
            + "				FROM\n"
            + "					LogEventosSistema A INNER JOIN TipoLog B\n"
            + "					ON A.TipoLog_IdTipo  = B.IdTipo \n"
            + "				WHERE \n"
            + "					(A.IdEmpresa  = 'EXTRAC') \n"
            + "					AND (CONVERT(DATE, A.FechaCreacion) BETWEEN '${fechaIni}' AND '${fechaFin}')\n"
            + "					AND (DATEPART(HOUR, A.FechaCreacion) >= 2 AND DATEPART(MINUTE, A.FechaCreacion) >=20) \n"
            + "					AND (DATEPART(HOUR, A.FechaCreacion) <= 2 AND DATEPART(MINUTE, A.FechaCreacion) <=25 AND DATEPART(SECOND, A.FechaCreacion) <= 59)\n"
            + "				GROUP BY \n"
            + "					CONVERT(DATE, A.FechaCreacion)\n"
            + "				) B\n"
            + "				ON A.FechaCreacion = B.FECHAPROCESOFIN \n"
            + "				AND CONVERT(DATE, A.FechaCreacion) = B.FECHAPROCESO INNER JOIN TipoLog C\n"
            + "				ON A.TipoLog_IdTipo  = C.IdTipo\n"
            + "	) B \n"
            + "	ON A.FECHAPROCESO = B.FECHAPROCESO INNER JOIN EmpresaProceso C\n"
            + "	ON A.IDEMPRESA = C.IdEmpresa\n"
            + "ORDER BY\n"
            + "	A.FECHAPROCESO DESC";

}
