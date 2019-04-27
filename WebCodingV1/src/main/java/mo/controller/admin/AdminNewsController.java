package mo.controller.admin;

import mo.core.Result;
import mo.entity.po.News;

public interface AdminNewsController {
    /**
     * 创建新闻
     *
     * @param news 新闻实体json
     * @return http状态码
     */
    Result createNews(String news);

    /**
     * 查询新闻
     *
     * @param page     页码
     * @param per_page 每页数量
     * @return
     */
    Result getNews(String page, String per_page);

    /**
     * 创建新闻
     *
     * @param news 新闻实体json
     * @return http状态码
     */
    Result updateNews(News news);


    /**
     * 删除指定公告
     *
     * @param news_id 公告Id
     * @return http状态码
     */
    Result deleteNews(Integer news_id);
}