package unired.api.extract;

import io.quarkiverse.mybatis.runtime.meta.MapperDataSource;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
@MapperDataSource("extract")
public interface ProcesoExtractMapper {
    
    @Select(Querys.EXTRACT_DIA_ACTUAL)
    List<ProcesoExtract> getExtractDiaActual();
    
    @Select(Querys.HISTORICO_EXTRACT)
    List<ProcesoExtractCompleto> getHistoricoExtract(String fechaIni, String fechaFin);
    
}
