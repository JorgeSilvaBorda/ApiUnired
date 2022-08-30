package unired.api.rendiciones;

import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TipoDiaMapper {
    /*
    @ConstructorArgs({
	@Arg(name = "feriado", column = "feriado", javaType = java.lang.Integer.class),
	@Arg(name = "finSemana", column = "finSemana", javaType = java.lang.Integer.class),
	@Arg(name = "ayerFeriado", column = "ayerFeriado", javaType = java.lang.Integer.class)
    })
    */
    /*
    @Results({
	@Result(property = "feriado", column = "feriado", javaType = java.lang.Integer.class),
	@Result(property = "finSemana", column = "finSemana", javaType = java.lang.Integer.class),
	@Result(property = "ayerFeriado", column = "ayerFeriado", javaType = java.lang.Integer.class)
    })
    @ResultType(TipoDia.class)
    */
    @Select("SELECT\n"
	    + "	SUM(\n"
	    + "		CASE\n"
	    + "			WHEN CONVERT(DATE, GETDATE()) = CONVERT(DATE, FechaFeriado) THEN 1 ELSE 0\n"
	    + "		END\n"
	    + "	    ) as feriado,\n"
	    + "	CASE\n"
	    + "	    WHEN DATEPART(WEEKDAY, GETDATE()) IN (7, 1) THEN 1 ELSE 0\n"
	    + "	END as finSemana,\n"
	    + "	CASE\n"
	    + "	    WHEN DATEPART(WEEKDAY, DATEADD(DAY, -1, CONVERT(DATE,GETDATE()))) = 1 "
	    + "		OR "
	    + "	    SUM("
	    + "		CASE "
	    + "		    WHEN DATEADD(DAY, -1, CONVERT(DATE, GETDATE())) = CONVERT(DATE, FechaFeriado) THEN 1 ELSE 0\n"
	    + "		END \n"
	    + "		) > 0 THEN 1 ELSE 0\n"
	    + "	END as ayerFeriado\n"
	    + "FROM  Feriados")
    TipoDia obtenerTipoDiaHoy();
}
