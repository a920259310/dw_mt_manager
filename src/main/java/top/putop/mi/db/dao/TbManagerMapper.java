package top.putop.mi.db.dao;

import top.putop.mi.db.model.TbManager;

public interface TbManagerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_manager
     *
     * @mbggenerated Fri Jul 24 18:10:02 CST 2020
     */
    int deleteByPrimaryKey(Integer tbId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_manager
     *
     * @mbggenerated Fri Jul 24 18:10:02 CST 2020
     */
    int insert(TbManager record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_manager
     *
     * @mbggenerated Fri Jul 24 18:10:02 CST 2020
     */
    int insertSelective(TbManager record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_manager
     *
     * @mbggenerated Fri Jul 24 18:10:02 CST 2020
     */
    TbManager selectByPrimaryKey(Integer tbId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_manager
     *
     * @mbggenerated Fri Jul 24 18:10:02 CST 2020
     */
    int updateByPrimaryKeySelective(TbManager record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_manager
     *
     * @mbggenerated Fri Jul 24 18:10:02 CST 2020
     */
    int updateByPrimaryKey(TbManager record);
}