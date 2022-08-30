package unired.api.rendiciones;

public class Querys {

    public static final String PROGRAMADO_DIA_FERIADO = ""
	    + "SELECT COUNT(*)\n"
	    + "	FROM \n"
	    + "	TareasProgramadas t\n"
	    + "	,PlanRendiciones p\n"
	    + "	,DefinicionArchivos d\n"
	    + "	WHERE \n"
	    + "	t.Vigente = 'S'\n"
	    + "	and t.PlanRendiciones_IdEmpresa = p.IdEmpresa\n"
	    + "	and p.IdEmpresa = d.IdEmpresa\n"
	    + "	and d.Vigente = 'S'\n"
	    + "	and (((DATEPART(WEEKDAY, CONVERT(DATE, DATEADD(DAY, 0, GETDATE())))) = 7\n"
	    + "	    or (DATEPART(WEEKDAY, CONVERT(DATE, DATEADD(DAY, 0, GETDATE())))) = 1\n"
	    + "	    or (CONVERT(DATE, GETDATE()) =  (SELECT CONVERT(DATE, f.FechaFeriado) \n"
	    + "	    FROM Feriados f\n"
	    + "	    WHERE CONVERT(DATE, GETDATE()) = CONVERT(DATE, f.FechaFeriado))))\n"
	    + "	    and d.TipoRendicion = 97\n"
	    + "	    and p.TipoCorte = '14'\n"
	    + "	    and d.TipoRendicion != 99\n"
	    + "	)";

    public static final String PROGRAMADO_DIA_POSTFERIADO = "SELECT COUNT(*)\n"
	    + " FROM \n"
	    + "	TareasProgramadas t\n"
	    + "	,PlanRendiciones p\n"
	    + "	,DefinicionArchivos d\n"
	    + "	WHERE \n"
	    + "	t.Vigente = 'S'\n"
	    + "	and t.PlanRendiciones_IdEmpresa = p.IdEmpresa\n"
	    + "	and p.IdEmpresa = d.IdEmpresa\n"
	    + "	and d.Vigente = 'S'\n"
	    + "	and (((DATEPART(WEEKDAY, CONVERT(DATE, DATEADD(DAY, 0, GETDATE())))) != 7\n"
	    + "	    or (DATEPART(WEEKDAY, CONVERT(DATE, DATEADD(DAY, 0, GETDATE())))) != 1\n"
	    + "	    or (CONVERT(DATE, GETDATE()) !=  (SELECT CONVERT(DATE, f.FechaFeriado) \n"
	    + "		FROM Feriados f\n"
	    + "	    	WHERE CONVERT(DATE, GETDATE()) = CONVERT(DATE, f.FechaFeriado))))\n"
	    + "		    and (d.TipoRendicion = 97 or d.TipoRendicion = 99)\n"
	    + "		)\n"
	    + "	and (\n"
	    + "	(DATEPART(WEEKDAY, CONVERT(DATE, DATEADD(DAY, -1, GETDATE())))) = 1\n"
	    + "	    OR\n"
	    + "	(CONVERT(DATE, DATEADD(DAY, -1, GETDATE())) =  (SELECT CONVERT(DATE, f.FechaFeriado) \n"
	    + "	    FROM Feriados f\n"
	    + "	    WHERE CONVERT(DATE, GETDATE()) = CONVERT(DATE, f.FechaFeriado)))\n"
	    + "	)";

    public static final String PROGRAMADO_DIA_NORMAL = ""
	    + "SELECT COUNT(*)\n"
	    + "	FROM TareasProgramadas t\n"
	    + "		,PlanRendiciones p\n"
	    + "		,DefinicionArchivos d\n"
	    + "	WHERE t.Vigente = 'S'\n"
	    + "	  and t.PlanRendiciones_IdEmpresa = p.IdEmpresa\n"
	    + "	  and p.IdEmpresa = d.IdEmpresa\n"
	    + "	  and d.Vigente = 'S'";

    public static final String PROCESOS_DIA_NORMAL = "SELECT \n"
	    + "	t.IdTarea,\n"
	    + "	SUBSTRING(t.HoraEjecucion, 1, 2) + ':' + SUBSTRING(t.HoraEjecucion, 3, 2) + ':' + SUBSTRING(t.HoraEjecucion, 5, 2) horaEjecucion,\n"
	    + "	e.IdEmpresa idEmpresa,\n"
	    + "	e.NombreEps nombreEps\n"
	    + "		FROM \n"
	    + "			TareasProgramadas t\n"
	    + "	    	,PlanRendiciones p\n"
	    + "	    	,DefinicionArchivos d,\n"
	    + "			Empresas e\n"
	    + "	    WHERE \n"
	    + "	    	t.Vigente = 'S'\n"
	    + "			and p.IdEmpresa = e.IdEmpresa\n"
	    + "	      	and t.PlanRendiciones_IdEmpresa = p.IdEmpresa\n"
	    + "	      	and p.IdEmpresa = d.IdEmpresa\n"
	    + "	      	and d.Vigente = 'S'\n"
	    + "	      	and (\n"
	    + "				  (\n"
	    + "				  	(DATEPART(WEEKDAY, CONVERT(DATE, DATEADD(DAY, 0, GETDATE())))) != 7\n"
	    + "	          			or \n"
	    + "				  	(DATEPART(WEEKDAY, CONVERT(DATE, DATEADD(DAY, 0, GETDATE())))) != 1\n"
	    + "	    	  			or \n"
	    + "				  	(CONVERT(DATE, GETDATE()) !=  (SELECT CONVERT(DATE, f.FechaFeriado) \n"
	    + "	    								      FROM Feriados f\n"
	    + "	    									  WHERE CONVERT(DATE, GETDATE()) = CONVERT(DATE, f.FechaFeriado))))\n"
	    + "	    	 	and \n"
	    + "				 (d.TipoRendicion = 97 or d.TipoRendicion = 99)\n"
	    + "				 )\n"
	    + "			and (\n"
	    + "				(DATEPART(WEEKDAY, CONVERT(DATE, DATEADD(DAY, -1, GETDATE())))) != 1\n"
	    + "					OR\n"
	    + "				(DATEPART(WEEKDAY, CONVERT(DATE, DATEADD(DAY, -1, GETDATE())))) != 7\n"
	    + "					OR\n"
	    + "				(CONVERT(DATE, DATEADD(DAY, -1, GETDATE())) !=  (SELECT CONVERT(DATE, f.FechaFeriado) \n"
	    + "	    								      FROM Feriados f\n"
	    + "	    									  WHERE CONVERT(DATE, GETDATE()) = CONVERT(DATE, f.FechaFeriado)))\n"
	    + "			)";

    public static final String PROCESOS_DIA_FERIADO = "SELECT t.IdTarea,\n"
	    + "	SUBSTRING(t.HoraEjecucion, 1, 2) + ':' + SUBSTRING(t.HoraEjecucion, 3, 2) + ':' + SUBSTRING(t.HoraEjecucion, 5, 2) horaEjecucion,\n"
	    + "	e.IdEmpresa idEmpresa,\n"
	    + "	e.NombreEps nombreEps\n"
	    + "		FROM \n"
	    + "			TareasProgramadas t\n"
	    + "	    	,PlanRendiciones p\n"
	    + "	    	,DefinicionArchivos d,\n"
	    + "			Empresas e\n"
	    + "	    WHERE \n"
	    + "	    	t.Vigente = 'S'\n"
	    + "			and p.IdEmpresa = e.IdEmpresa\n"
	    + "	      	and t.PlanRendiciones_IdEmpresa = p.IdEmpresa\n"
	    + "	      	and p.IdEmpresa = d.IdEmpresa\n"
	    + "	      	and d.Vigente = 'S'\n"
	    + "	      	and (((DATEPART(WEEKDAY, CONVERT(DATE, DATEADD(DAY, 0, GETDATE())))) = 7\n"
	    + "	          	or (DATEPART(WEEKDAY, CONVERT(DATE, DATEADD(DAY, 0, GETDATE())))) = 1\n"
	    + "	    	  	or (CONVERT(DATE, GETDATE()) =  (SELECT CONVERT(DATE, f.FechaFeriado) \n"
	    + "	    								      FROM Feriados f\n"
	    + "	    									  WHERE CONVERT(DATE, GETDATE()) = CONVERT(DATE, f.FechaFeriado))))\n"
	    + "	    	 	and d.TipoRendicion = 97\n"
	    + "	    		and p.TipoCorte = '14'\n"
	    + "	    		and d.TipoRendicion != 99\n"
	    + "			)";

    public static final String PROCESOS_DIA_POSTFERIADO = "SELECT \n"
	    + "	  		*\n"
	    + "	    	FROM \n"
	    + "	    		TareasProgramadas t inner join PlanRendiciones p\n"
	    + "	    		on t.PlanRendiciones_IdEmpresa = p.IdEmpresa inner join DefinicionArchivos d\n"
	    + "	    		on p.IdEmpresa = d.IdEmpresa\n"
	    + "	    	WHERE \n"
	    + "	    		t.Vigente = 'S'\n"
	    + "	    		and d.Vigente = 'S'\n"
	    + "	    		or \n"
	    + "	    		(\n"
	    + "	    			p.TipoCorte = '14' and d.TipoRendicion = 97\n"
	    + "	    			and\n"
	    + "	    				(\n"
	    + "	    					(\n"
	    + "								((DATEPART(WEEKDAY, CONVERT(DATE, getdate()))) = 7 and convert(date, getdate()) = convert(date, getdate()))\n"
	    + "	    						or\n"
	    + "	    					((DATEPART(WEEKDAY, CONVERT(DATE, getdate()))) = 1 and convert(date, getdate()) = convert(date, getDate()))\n"
	    + "	    					or\n"
	    + "	    					(CONVERT(DATE, GETDATE()) = (SELECT CONVERT(DATE, f.FechaFeriado) \n"
	    + "	    												FROM Feriados f\n"
	    + "	    												WHERE CONVERT(DATE, GETDATE()) = CONVERT(DATE, f.FechaFeriado)))\n"
	    + "	    						and d.TipoRendicion = 97\n"
	    + "	    						and p.TipoCorte = '14'\n"
	    + "	    						and d.TipoRendicion != 99\n"
	    + "								\n"
	    + "	    					)\n"
	    + "	    				)\n"
	    + "	    			)";

    public static final String CUENTA_ESTADOS = ""
	    + "SELECT \n"
	    + "	ISNULL(SUM(CASE WHEN s.EstadoProceso = 56 or s.EstadoProceso = 25 THEN 1 ELSE 0 END), 0) pendiente,\n"
	    + "	ISNULL(SUM(CASE WHEN s.EstadoProceso = 26 THEN 1 ELSE 0 END), 0) enEjecucion,\n"
	    + "	ISNULL(SUM(CASE WHEN s.EstadoProceso = 27 THEN 1 ELSE 0 END), 0) generado,\n"
	    + "	ISNULL(SUM(CASE WHEN s.EstadoProceso = 28 THEN 1 ELSE 0 END), 0) transmitido,\n"
	    + "	ISNULL(SUM(CASE WHEN s.EstadoProceso = 29 THEN 1 ELSE 0 END), 0) fallaEnProceso,\n"
	    + "	ISNULL(SUM(CASE WHEN s.EstadoProceso = 40 THEN 1 ELSE 0 END), 0) enviadoAMail,\n"
	    + "	ISNULL(SUM(CASE WHEN s.EstadoProceso = 4046 THEN 1 ELSE 0 END), 0) rendicionVacia,\n"
	    + "	ISNULL(SUM(CASE WHEN s.EstadoProceso IN(27, 40, 4046) THEN 1 END), 0) exitoso\n"
	    + "FROM \n"
	    + "	TareasProgramadas t inner join PlanRendiciones p\n"
	    + "	on t.PlanRendiciones_IdEmpresa = p.IdEmpresa inner join  DefinicionArchivos d\n"
	    + "	on d.IdEmpresa = p.IdEmpresa inner join Procesos s\n"
	    + "	on d.IdDefinicionArchivos = s.DefinicionArchivos_IdDefinicionArchivos left join Feriados f\n"
	    + "	on CONVERT(DATE, s.FechaCreacion) = CONVERT(DATE, f.FechaFeriado) \n"
	    + "WHERE \n"
	    + "	t.Vigente = 'S'\n"
	    + "	and d.Vigente = 'S'		\n"
	    + "	AND\n"
	    + "	(\n"
	    + "		((CONVERT(DATE, s.FechaCreacion) = CONVERT(DATE, DATEADD(DAY, -1, GETDATE()))) and (d.TipoRendicion != 97 and d.TipoRendicion != 99))\n"
	    + "	    	OR\n"
	    + "	    (CONVERT(DATE, s.FechaCreacion) = CONVERT(DATE, GETDATE()) and s.EstadoProceso != 56)\n"
	    + "	    	OR\n"
	    + "	    (\n"
	    + "	    	p.TipoCorte = '14' and d.TipoRendicion = 97\n"
	    + "	    		and\n"
	    + "	    	   	(\n"
	    + "	    			(((DATEPART(WEEKDAY, CONVERT(DATE, s.FechaCreacion))) = 7 and convert(date, s.FechaCreacion) = convert(date, getdate()))\n"
	    + "	    	       		or\n"
	    + "	    			((DATEPART(WEEKDAY, CONVERT(DATE, s.FechaCreacion))) = 1 and convert(date, s.FechaCreacion) = convert(date, getDate()))\n"
	    + "	    	   	  		or\n"
	    + "	    	   		(CONVERT(DATE, GETDATE()) = (CONVERT(DATE, f.FechaFeriado))))\n"
	    + "	    			    and d.TipoRendicion = 97\n"
	    + "	    			    and p.TipoCorte = '14'\n"
	    + "	    			    and d.TipoRendicion != 99\n"
	    + "	    		)\n"
	    + "   		)\n"
	    + "   	)";

    public static final String SUB_PROCESOS = "SELECT\n"
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

    public static final String EN_EJECUCION = "SELECT \n"
	    + "	s.IdProceso idProceso,\n"
	    + "	s.IdEmpresa idEmpresa,\n"
	    + "	e.NombreEps nombreEps,\n"
	    + "	s.EstadoProceso estadoProceso,\n"
	    + "	s.FechaProceso fechaProceso,\n"
	    + "	s.FechaCreacion fechaCreacion,\n"
	    + "	s.InicioProceso inicioProceso,\n"
	    + "	s.FinProceso finProceso,\n"
	    + "	p.TipoCorte,\n"
	    + "	d.TipoRendicion,\n"
	    + "	d.IdDefinicionArchivos\n"
	    + "FROM \n"
	    + "	TareasProgramadas t inner join PlanRendiciones p\n"
	    + "	on t.PlanRendiciones_IdEmpresa = p.IdEmpresa inner join  DefinicionArchivos d\n"
	    + "	on d.IdEmpresa = p.IdEmpresa inner join Procesos s\n"
	    + "	on d.IdDefinicionArchivos = s.DefinicionArchivos_IdDefinicionArchivos left join Feriados f\n"
	    + "	on CONVERT(DATE, s.FechaCreacion) = CONVERT(DATE, f.FechaFeriado) inner join Empresas e\n"
	    + "	on s.IdEmpresa = e.IdEmpresa\n"
	    + "WHERE \n"
	    + "	t.Vigente = 'S'\n"
	    + "	   	and d.Vigente = 'S'		\n"
	    + "	   	AND\n"
	    + "	   	(\n"
	    + "	   		((CONVERT(DATE, s.FechaCreacion) = CONVERT(DATE, DATEADD(DAY, -1, GETDATE()))) and (d.TipoRendicion != 97 and d.TipoRendicion != 99))\n"
	    + "	   	 		OR\n"
	    + "	   		(CONVERT(DATE, s.FechaCreacion) = CONVERT(DATE, GETDATE()) and s.EstadoProceso != 56)\n"
	    + "	   			OR\n"
	    + "	   		(\n"
	    + "	   			p.TipoCorte = '14' and d.TipoRendicion = 97\n"
	    + "	   				and\n"
	    + "	   			(\n"
	    + "					(((DATEPART(WEEKDAY, CONVERT(DATE, s.FechaCreacion))) = 7 and convert(date, s.FechaCreacion) = convert(date, getdate()))\n"
	    + "	       				or\n"
	    + "					((DATEPART(WEEKDAY, CONVERT(DATE, s.FechaCreacion))) = 1 and convert(date, s.FechaCreacion) = convert(date, getDate()))\n"
	    + "	   	  				or\n"
	    + "	   				(CONVERT(DATE, GETDATE()) = (CONVERT(DATE, f.FechaFeriado))))\n"
	    + "					   and d.TipoRendicion = 97\n"
	    + "					   and p.TipoCorte = '14'\n"
	    + "					   and d.TipoRendicion != 99\n"
	    + "	   	  		)\n"
	    + "	   		)\n"
	    + "	   	)\n"
	    + " AND s.EstadoProceso = 26 "
	    + " ORDER BY s.IdProceso ASC";

    public static final String TRANSMITIDOS = "SELECT \n"
	    + "	s.IdProceso idProceso,\n"
	    + "	s.IdEmpresa idEmpresa,\n"
	    + "	e.NombreEps nombreEps,\n"
	    + "	s.EstadoProceso estadoProceso,\n"
	    + "	s.FechaProceso fechaProceso,\n"
	    + "	s.FechaCreacion fechaCreacion,\n"
	    + "	s.InicioProceso inicioProceso,\n"
	    + "	s.FinProceso finProceso,\n"
	    + "	p.TipoCorte,\n"
	    + "	d.TipoRendicion,\n"
	    + "	d.IdDefinicionArchivos\n"
	    + "FROM \n"
	    + "	TareasProgramadas t inner join PlanRendiciones p\n"
	    + "	on t.PlanRendiciones_IdEmpresa = p.IdEmpresa inner join  DefinicionArchivos d\n"
	    + "	on d.IdEmpresa = p.IdEmpresa inner join Procesos s\n"
	    + "	on d.IdDefinicionArchivos = s.DefinicionArchivos_IdDefinicionArchivos left join Feriados f\n"
	    + "	on CONVERT(DATE, s.FechaCreacion) = CONVERT(DATE, f.FechaFeriado) inner join Empresas e\n"
	    + "	on s.IdEmpresa = e.IdEmpresa\n"
	    + "WHERE \n"
	    + "	t.Vigente = 'S'\n"
	    + "	   	and d.Vigente = 'S'		\n"
	    + "	   	AND\n"
	    + "	   	(\n"
	    + "	   		((CONVERT(DATE, s.FechaCreacion) = CONVERT(DATE, DATEADD(DAY, -1, GETDATE()))) and (d.TipoRendicion != 97 and d.TipoRendicion != 99))\n"
	    + "	   	 		OR\n"
	    + "	   		(CONVERT(DATE, s.FechaCreacion) = CONVERT(DATE, GETDATE()) and s.EstadoProceso != 56)\n"
	    + "	   			OR\n"
	    + "	   		(\n"
	    + "	   			p.TipoCorte = '14' and d.TipoRendicion = 97\n"
	    + "	   				and\n"
	    + "	   			(\n"
	    + "					(((DATEPART(WEEKDAY, CONVERT(DATE, s.FechaCreacion))) = 7 and convert(date, s.FechaCreacion) = convert(date, getdate()))\n"
	    + "	       				or\n"
	    + "					((DATEPART(WEEKDAY, CONVERT(DATE, s.FechaCreacion))) = 1 and convert(date, s.FechaCreacion) = convert(date, getDate()))\n"
	    + "	   	  				or\n"
	    + "	   				(CONVERT(DATE, GETDATE()) = (CONVERT(DATE, f.FechaFeriado))))\n"
	    + "					   and d.TipoRendicion = 97\n"
	    + "					   and p.TipoCorte = '14'\n"
	    + "					   and d.TipoRendicion != 99\n"
	    + "	   	  		)\n"
	    + "	   		)\n"
	    + "	   	)\n"
	    + " AND s.EstadoProceso in(28) "
	    + " ORDER BY s.IdProceso ASC";

    public static final String GENERADOS = "SELECT \n"
	    + "	s.IdProceso idProceso,\n"
	    + "	s.IdEmpresa idEmpresa,\n"
	    + "	e.NombreEps nombreEps,\n"
	    + "	s.EstadoProceso estadoProceso,\n"
	    + "	s.FechaProceso fechaProceso,\n"
	    + "	s.FechaCreacion fechaCreacion,\n"
	    + "	s.InicioProceso inicioProceso,\n"
	    + "	s.FinProceso finProceso,\n"
	    + "	p.TipoCorte,\n"
	    + "	d.TipoRendicion,\n"
	    + "	d.IdDefinicionArchivos\n"
	    + "FROM \n"
	    + "	TareasProgramadas t inner join PlanRendiciones p\n"
	    + "	on t.PlanRendiciones_IdEmpresa = p.IdEmpresa inner join  DefinicionArchivos d\n"
	    + "	on d.IdEmpresa = p.IdEmpresa inner join Procesos s\n"
	    + "	on d.IdDefinicionArchivos = s.DefinicionArchivos_IdDefinicionArchivos left join Feriados f\n"
	    + "	on CONVERT(DATE, s.FechaCreacion) = CONVERT(DATE, f.FechaFeriado) inner join Empresas e\n"
	    + "	on s.IdEmpresa = e.IdEmpresa\n"
	    + "WHERE \n"
	    + "	t.Vigente = 'S'\n"
	    + "	   	and d.Vigente = 'S'		\n"
	    + "	   	AND\n"
	    + "	   	(\n"
	    + "	   		((CONVERT(DATE, s.FechaCreacion) = CONVERT(DATE, DATEADD(DAY, -1, GETDATE()))) and (d.TipoRendicion != 97 and d.TipoRendicion != 99))\n"
	    + "	   	 		OR\n"
	    + "	   		(CONVERT(DATE, s.FechaCreacion) = CONVERT(DATE, GETDATE()) and s.EstadoProceso != 56)\n"
	    + "	   			OR\n"
	    + "	   		(\n"
	    + "	   			p.TipoCorte = '14' and d.TipoRendicion = 97\n"
	    + "	   				and\n"
	    + "	   			(\n"
	    + "					(((DATEPART(WEEKDAY, CONVERT(DATE, s.FechaCreacion))) = 7 and convert(date, s.FechaCreacion) = convert(date, getdate()))\n"
	    + "	       				or\n"
	    + "					((DATEPART(WEEKDAY, CONVERT(DATE, s.FechaCreacion))) = 1 and convert(date, s.FechaCreacion) = convert(date, getDate()))\n"
	    + "	   	  				or\n"
	    + "	   				(CONVERT(DATE, GETDATE()) = (CONVERT(DATE, f.FechaFeriado))))\n"
	    + "					   and d.TipoRendicion = 97\n"
	    + "					   and p.TipoCorte = '14'\n"
	    + "					   and d.TipoRendicion != 99\n"
	    + "	   	  		)\n"
	    + "	   		)\n"
	    + "	   	)\n"
	    + " AND s.EstadoProceso in(27) "
	    + " ORDER BY s.IdProceso ASC";

    public static final String RENDICION_VACIA = "SELECT \n"
	    + "	s.IdProceso idProceso,\n"
	    + "	s.IdEmpresa idEmpresa,\n"
	    + "	e.NombreEps nombreEps,\n"
	    + "	s.EstadoProceso estadoProceso,\n"
	    + "	s.FechaProceso fechaProceso,\n"
	    + "	s.FechaCreacion fechaCreacion,\n"
	    + "	s.InicioProceso inicioProceso,\n"
	    + "	s.FinProceso finProceso,\n"
	    + "	p.TipoCorte,\n"
	    + "	d.TipoRendicion,\n"
	    + "	d.IdDefinicionArchivos\n"
	    + "FROM \n"
	    + "	TareasProgramadas t inner join PlanRendiciones p\n"
	    + "	on t.PlanRendiciones_IdEmpresa = p.IdEmpresa inner join  DefinicionArchivos d\n"
	    + "	on d.IdEmpresa = p.IdEmpresa inner join Procesos s\n"
	    + "	on d.IdDefinicionArchivos = s.DefinicionArchivos_IdDefinicionArchivos left join Feriados f\n"
	    + "	on CONVERT(DATE, s.FechaCreacion) = CONVERT(DATE, f.FechaFeriado) inner join Empresas e\n"
	    + "	on s.IdEmpresa = e.IdEmpresa\n"
	    + "WHERE \n"
	    + "	t.Vigente = 'S'\n"
	    + "	   	and d.Vigente = 'S'		\n"
	    + "	   	AND\n"
	    + "	   	(\n"
	    + "	   		((CONVERT(DATE, s.FechaCreacion) = CONVERT(DATE, DATEADD(DAY, -1, GETDATE()))) and (d.TipoRendicion != 97 and d.TipoRendicion != 99))\n"
	    + "	   	 		OR\n"
	    + "	   		(CONVERT(DATE, s.FechaCreacion) = CONVERT(DATE, GETDATE()) and s.EstadoProceso != 56)\n"
	    + "	   			OR\n"
	    + "	   		(\n"
	    + "	   			p.TipoCorte = '14' and d.TipoRendicion = 97\n"
	    + "	   				and\n"
	    + "	   			(\n"
	    + "					(((DATEPART(WEEKDAY, CONVERT(DATE, s.FechaCreacion))) = 7 and convert(date, s.FechaCreacion) = convert(date, getdate()))\n"
	    + "	       				or\n"
	    + "					((DATEPART(WEEKDAY, CONVERT(DATE, s.FechaCreacion))) = 1 and convert(date, s.FechaCreacion) = convert(date, getDate()))\n"
	    + "	   	  				or\n"
	    + "	   				(CONVERT(DATE, GETDATE()) = (CONVERT(DATE, f.FechaFeriado))))\n"
	    + "					   and d.TipoRendicion = 97\n"
	    + "					   and p.TipoCorte = '14'\n"
	    + "					   and d.TipoRendicion != 99\n"
	    + "	   	  		)\n"
	    + "	   		)\n"
	    + "	   	)\n"
	    + " AND s.EstadoProceso = 4046 "
	    + " ORDER BY s.IdProceso ASC";

    public static final String ENVIADOS_MAIL = "SELECT \n"
	    + "	s.IdProceso idProceso,\n"
	    + "	s.IdEmpresa idEmpresa,\n"
	    + "	e.NombreEps nombreEps,\n"
	    + "	s.EstadoProceso estadoProceso,\n"
	    + "	s.FechaProceso fechaProceso,\n"
	    + "	s.FechaCreacion fechaCreacion,\n"
	    + "	s.InicioProceso inicioProceso,\n"
	    + "	s.FinProceso finProceso,\n"
	    + "	p.TipoCorte,\n"
	    + "	d.TipoRendicion,\n"
	    + "	d.IdDefinicionArchivos\n"
	    + "FROM \n"
	    + "	TareasProgramadas t inner join PlanRendiciones p\n"
	    + "	on t.PlanRendiciones_IdEmpresa = p.IdEmpresa inner join  DefinicionArchivos d\n"
	    + "	on d.IdEmpresa = p.IdEmpresa inner join Procesos s\n"
	    + "	on d.IdDefinicionArchivos = s.DefinicionArchivos_IdDefinicionArchivos left join Feriados f\n"
	    + "	on CONVERT(DATE, s.FechaCreacion) = CONVERT(DATE, f.FechaFeriado) inner join Empresas e\n"
	    + "	on s.IdEmpresa = e.IdEmpresa\n"
	    + "WHERE \n"
	    + "	t.Vigente = 'S'\n"
	    + "	   	and d.Vigente = 'S'		\n"
	    + "	   	AND\n"
	    + "	   	(\n"
	    + "	   		((CONVERT(DATE, s.FechaCreacion) = CONVERT(DATE, DATEADD(DAY, -1, GETDATE()))) and (d.TipoRendicion != 97 and d.TipoRendicion != 99))\n"
	    + "	   	 		OR\n"
	    + "	   		(CONVERT(DATE, s.FechaCreacion) = CONVERT(DATE, GETDATE()) and s.EstadoProceso != 56)\n"
	    + "	   			OR\n"
	    + "	   		(\n"
	    + "	   			p.TipoCorte = '14' and d.TipoRendicion = 97\n"
	    + "	   				and\n"
	    + "	   			(\n"
	    + "					(((DATEPART(WEEKDAY, CONVERT(DATE, s.FechaCreacion))) = 7 and convert(date, s.FechaCreacion) = convert(date, getdate()))\n"
	    + "	       				or\n"
	    + "					((DATEPART(WEEKDAY, CONVERT(DATE, s.FechaCreacion))) = 1 and convert(date, s.FechaCreacion) = convert(date, getDate()))\n"
	    + "	   	  				or\n"
	    + "	   				(CONVERT(DATE, GETDATE()) = (CONVERT(DATE, f.FechaFeriado))))\n"
	    + "					   and d.TipoRendicion = 97\n"
	    + "					   and p.TipoCorte = '14'\n"
	    + "					   and d.TipoRendicion != 99\n"
	    + "	   	  		)\n"
	    + "	   		)\n"
	    + "	   	)\n"
	    + " AND s.EstadoProceso = 40 "
	    + "ORDER BY s.IdProceso ASC";

    public static final String PENDIENTES = "SELECT \n"
	    + "	s.IdProceso idProceso,\n"
	    + "	s.IdEmpresa idEmpresa,\n"
	    + "	e.NombreEps nombreEps,\n"
	    + "	s.EstadoProceso estadoProceso,\n"
	    + "	s.FechaProceso fechaProceso,\n"
	    + "	s.FechaCreacion fechaCreacion,\n"
	    + "	s.InicioProceso inicioProceso,\n"
	    + "	s.FinProceso finProceso,\n"
	    + "	p.TipoCorte,\n"
	    + "	d.TipoRendicion,\n"
	    + "	d.IdDefinicionArchivos\n"
	    + "FROM \n"
	    + "	TareasProgramadas t inner join PlanRendiciones p\n"
	    + "	on t.PlanRendiciones_IdEmpresa = p.IdEmpresa inner join  DefinicionArchivos d\n"
	    + "	on d.IdEmpresa = p.IdEmpresa inner join Procesos s\n"
	    + "	on d.IdDefinicionArchivos = s.DefinicionArchivos_IdDefinicionArchivos left join Feriados f\n"
	    + "	on CONVERT(DATE, s.FechaCreacion) = CONVERT(DATE, f.FechaFeriado) inner join Empresas e\n"
	    + "	on s.IdEmpresa = e.IdEmpresa\n"
	    + "WHERE \n"
	    + "	t.Vigente = 'S'\n"
	    + "	   	and d.Vigente = 'S'		\n"
	    + "	   	AND\n"
	    + "	   	(\n"
	    + "	   		((CONVERT(DATE, s.FechaCreacion) = CONVERT(DATE, DATEADD(DAY, -1, GETDATE()))) and (d.TipoRendicion != 97 and d.TipoRendicion != 99))\n"
	    + "	   	 		OR\n"
	    + "	   		(CONVERT(DATE, s.FechaCreacion) = CONVERT(DATE, GETDATE()) and s.EstadoProceso != 56)\n"
	    + "	   			OR\n"
	    + "	   		(\n"
	    + "	   			p.TipoCorte = '14' and d.TipoRendicion = 97\n"
	    + "	   				and\n"
	    + "	   			(\n"
	    + "					(((DATEPART(WEEKDAY, CONVERT(DATE, s.FechaCreacion))) = 7 and convert(date, s.FechaCreacion) = convert(date, getdate()))\n"
	    + "	       				or\n"
	    + "					((DATEPART(WEEKDAY, CONVERT(DATE, s.FechaCreacion))) = 1 and convert(date, s.FechaCreacion) = convert(date, getDate()))\n"
	    + "	   	  				or\n"
	    + "	   				(CONVERT(DATE, GETDATE()) = (CONVERT(DATE, f.FechaFeriado))))\n"
	    + "					   and d.TipoRendicion = 97\n"
	    + "					   and p.TipoCorte = '14'\n"
	    + "					   and d.TipoRendicion != 99\n"
	    + "	   	  		)\n"
	    + "	   		)\n"
	    + "	   	)\n"
	    + " AND s.EstadoProceso IN (56, 25) "
	    + " ORDER BY s.IdProceso ASC";

    public static final String ERRORES = "SELECT \n"
	    + "	s.IdProceso idProceso,\n"
	    + "	s.IdEmpresa idEmpresa,\n"
	    + "	e.NombreEps nombreEps,\n"
	    + "	s.EstadoProceso estadoProceso,\n"
	    + "	s.FechaProceso fechaProceso,\n"
	    + "	s.FechaCreacion fechaCreacion,\n"
	    + "	s.InicioProceso inicioProceso,\n"
	    + "	s.FinProceso finProceso,\n"
	    + "	p.TipoCorte,\n"
	    + "	d.TipoRendicion,\n"
	    + "	d.IdDefinicionArchivos\n"
	    + "FROM \n"
	    + "	TareasProgramadas t inner join PlanRendiciones p\n"
	    + "	on t.PlanRendiciones_IdEmpresa = p.IdEmpresa inner join  DefinicionArchivos d\n"
	    + "	on d.IdEmpresa = p.IdEmpresa inner join Procesos s\n"
	    + "	on d.IdDefinicionArchivos = s.DefinicionArchivos_IdDefinicionArchivos left join Feriados f\n"
	    + "	on CONVERT(DATE, s.FechaCreacion) = CONVERT(DATE, f.FechaFeriado) inner join Empresas e\n"
	    + "	on s.IdEmpresa = e.IdEmpresa\n"
	    + "WHERE \n"
	    + "	t.Vigente = 'S'\n"
	    + "	   	and d.Vigente = 'S'		\n"
	    + "	   	AND\n"
	    + "	   	(\n"
	    + "	   		((CONVERT(DATE, s.FechaCreacion) = CONVERT(DATE, DATEADD(DAY, -1, GETDATE()))) and (d.TipoRendicion != 97 and d.TipoRendicion != 99))\n"
	    + "	   	 		OR\n"
	    + "	   		(CONVERT(DATE, s.FechaCreacion) = CONVERT(DATE, GETDATE()) and s.EstadoProceso != 56)\n"
	    + "	   			OR\n"
	    + "	   		(\n"
	    + "	   			p.TipoCorte = '14' and d.TipoRendicion = 97\n"
	    + "	   				and\n"
	    + "	   			(\n"
	    + "					(((DATEPART(WEEKDAY, CONVERT(DATE, s.FechaCreacion))) = 7 and convert(date, s.FechaCreacion) = convert(date, getdate()))\n"
	    + "	       				or\n"
	    + "					((DATEPART(WEEKDAY, CONVERT(DATE, s.FechaCreacion))) = 1 and convert(date, s.FechaCreacion) = convert(date, getDate()))\n"
	    + "	   	  				or\n"
	    + "	   				(CONVERT(DATE, GETDATE()) = (CONVERT(DATE, f.FechaFeriado))))\n"
	    + "					   and d.TipoRendicion = 97\n"
	    + "					   and p.TipoCorte = '14'\n"
	    + "					   and d.TipoRendicion != 99\n"
	    + "	   	  		)\n"
	    + "	   		)\n"
	    + "	   	)\n"
	    + " and s.EstadoProceso = 29";

    public static final String EXITOSOS = "SELECT \n"
	    + "	s.IdProceso idProceso,\n"
	    + "	s.IdEmpresa idEmpresa,\n"
	    + "	e.NombreEps nombreEps,\n"
	    + "	s.EstadoProceso estadoProceso,\n"
	    + "	s.FechaProceso fechaProceso,\n"
	    + "	s.FechaCreacion fechaCreacion,\n"
	    + "	s.InicioProceso inicioProceso,\n"
	    + "	s.FinProceso finProceso,\n"
	    + "	p.TipoCorte,\n"
	    + "	d.TipoRendicion,\n"
	    + "	d.IdDefinicionArchivos\n"
	    + "FROM \n"
	    + "	TareasProgramadas t inner join PlanRendiciones p\n"
	    + "	on t.PlanRendiciones_IdEmpresa = p.IdEmpresa inner join  DefinicionArchivos d\n"
	    + "	on d.IdEmpresa = p.IdEmpresa inner join Procesos s\n"
	    + "	on d.IdDefinicionArchivos = s.DefinicionArchivos_IdDefinicionArchivos left join Feriados f\n"
	    + "	on CONVERT(DATE, s.FechaCreacion) = CONVERT(DATE, f.FechaFeriado) inner join Empresas e\n"
	    + "	on s.IdEmpresa = e.IdEmpresa\n"
	    + "WHERE \n"
	    + "	t.Vigente = 'S'\n"
	    + "	   	and d.Vigente = 'S'		\n"
	    + "	   	AND\n"
	    + "	   	(\n"
	    + "	   		((CONVERT(DATE, s.FechaCreacion) = CONVERT(DATE, DATEADD(DAY, -1, GETDATE()))) and (d.TipoRendicion != 97 and d.TipoRendicion != 99))\n"
	    + "	   	 		OR\n"
	    + "	   		(CONVERT(DATE, s.FechaCreacion) = CONVERT(DATE, GETDATE()) and s.EstadoProceso != 56)\n"
	    + "	   			OR\n"
	    + "	   		(\n"
	    + "	   			p.TipoCorte = '14' and d.TipoRendicion = 97\n"
	    + "	   				and\n"
	    + "	   			(\n"
	    + "					(((DATEPART(WEEKDAY, CONVERT(DATE, s.FechaCreacion))) = 7 and convert(date, s.FechaCreacion) = convert(date, getdate()))\n"
	    + "	       				or\n"
	    + "					((DATEPART(WEEKDAY, CONVERT(DATE, s.FechaCreacion))) = 1 and convert(date, s.FechaCreacion) = convert(date, getDate()))\n"
	    + "	   	  				or\n"
	    + "	   				(CONVERT(DATE, GETDATE()) = (CONVERT(DATE, f.FechaFeriado))))\n"
	    + "					   and d.TipoRendicion = 97\n"
	    + "					   and p.TipoCorte = '14'\n"
	    + "					   and d.TipoRendicion != 99\n"
	    + "	   	  		)\n"
	    + "	   		)\n"
	    + "	   	)\n"
	    + " AND s.EstadoProceso in(27,40,4046) "
	    + " ORDER BY s.IdProceso ASC";

    public static final String EJECUTADOS = "SELECT \n"
	    + "	s.IdProceso idProceso,\n"
	    + "	s.IdEmpresa idEmpresa,\n"
	    + "	e.NombreEps nombreEps,\n"
	    + "	s.EstadoProceso estadoProceso,\n"
	    + "	s.FechaProceso fechaProceso,\n"
	    + "	s.FechaCreacion fechaCreacion,\n"
	    + "	s.InicioProceso inicioProceso,\n"
	    + "	s.FinProceso finProceso,\n"
	    + "	p.TipoCorte,\n"
	    + "	d.TipoRendicion,\n"
	    + "	d.IdDefinicionArchivos\n"
	    + "FROM \n"
	    + "	TareasProgramadas t inner join PlanRendiciones p\n"
	    + "	on t.PlanRendiciones_IdEmpresa = p.IdEmpresa inner join  DefinicionArchivos d\n"
	    + "	on d.IdEmpresa = p.IdEmpresa inner join Procesos s\n"
	    + "	on d.IdDefinicionArchivos = s.DefinicionArchivos_IdDefinicionArchivos left join Feriados f\n"
	    + "	on CONVERT(DATE, s.FechaCreacion) = CONVERT(DATE, f.FechaFeriado) inner join Empresas e\n"
	    + "	on s.IdEmpresa = e.IdEmpresa\n"
	    + "WHERE \n"
	    + "	t.Vigente = 'S'\n"
	    + "	   	and d.Vigente = 'S'		\n"
	    + "	   	AND\n"
	    + "	   	(\n"
	    + "	   		((CONVERT(DATE, s.FechaCreacion) = CONVERT(DATE, DATEADD(DAY, -1, GETDATE()))) and (d.TipoRendicion != 97 and d.TipoRendicion != 99))\n"
	    + "	   	 		OR\n"
	    + "	   		(CONVERT(DATE, s.FechaCreacion) = CONVERT(DATE, GETDATE()) and s.EstadoProceso != 56)\n"
	    + "	   			OR\n"
	    + "	   		(\n"
	    + "	   			p.TipoCorte = '14' and d.TipoRendicion = 97\n"
	    + "	   				and\n"
	    + "	   			(\n"
	    + "					(((DATEPART(WEEKDAY, CONVERT(DATE, s.FechaCreacion))) = 7 and convert(date, s.FechaCreacion) = convert(date, getdate()))\n"
	    + "	       				or\n"
	    + "					((DATEPART(WEEKDAY, CONVERT(DATE, s.FechaCreacion))) = 1 and convert(date, s.FechaCreacion) = convert(date, getDate()))\n"
	    + "	   	  				or\n"
	    + "	   				(CONVERT(DATE, GETDATE()) = (CONVERT(DATE, f.FechaFeriado))))\n"
	    + "					   and d.TipoRendicion = 97\n"
	    + "					   and p.TipoCorte = '14'\n"
	    + "					   and d.TipoRendicion != 99\n"
	    + "	   	  		)\n"
	    + "	   		)\n"
	    + "	   	)\n"
	    + " AND s.EstadoProceso in(27,28,29,40,4046) "
	    + " ORDER BY s.IdProceso ASC";

    public static final String TIPO_DIA = ""
	    + "SELECT \n"
	    + "	 SUM(\n"
	    + "	 CASE \n"
	    + "	    WHEN CONVERT(DATE, GETDATE()) = CONVERT(DATE, FechaFeriado) THEN 1 ELSE 0\n"
	    + "	 END\n"
	    + "	 ) esFeriado,\n"
	    + "	 CASE \n"
	    + "	 	WHEN DATEPART(WEEKDAY, GETDATE()) IN (7, 1) THEN 1 ELSE 0\n"
	    + "	 END esFinDeSemana,\n"
	    + "	 CASE \n"
	    + "	 	WHEN DATEPART(WEEKDAY, DATEADD(DAY, -1, CONVERT(DATE,GETDATE()))) = 1 OR SUM(CASE WHEN DATEADD(DAY, -1, CONVERT(DATE, GETDATE())) = CONVERT(DATE, FechaFeriado) THEN 1 ELSE 0 END ) > 0 THEN 1 ELSE 0\n"
	    + "	 END ayerFinDeSemanaOFeriado \n"
	    + "FROM\n"
	    + "	Feriados f ";
}
