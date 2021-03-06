package org.elianacc.yurayura.service.comic;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import org.elianacc.yurayura.dto.ComicInsertDto;
import org.elianacc.yurayura.dto.ComicSelectDto;
import org.elianacc.yurayura.dto.ComicUpdateDto;
import org.elianacc.yurayura.dto.IdsDto;
import org.elianacc.yurayura.entity.comic.Comic;

/**
 * 番剧 service
 *
 * @author ELiaNaCc
 * @since 2019-10-27
 */
public interface IComicService extends IService<Comic> {

    /**
     * 分页查询番剧
     *
     * @param dto
     * @return com.github.pagehelper.PageInfo<org.elianacc.yurayura.entity.comic.Comic>
     */
    public PageInfo<Comic> getPage(ComicSelectDto dto);

    /**
     * 添加番剧
     *
     * @param dto
     * @return java.lang.String
     */
    public String insert(ComicInsertDto dto);

    /**
     * 批量删除番剧（根据番剧id组）
     *
     * @param dto
     * @return void
     */
    public void deleteBatchByIds(IdsDto dto);

    /**
     * 修改番剧
     *
     * @param dto
     * @return java.lang.String
     */
    public String update(ComicUpdateDto dto);

}
