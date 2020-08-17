package top.putop.mi.controller.dw_mt_manager;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.putop.mi.service.ISrcManagerService;

/**
 * 数据源控制类
 * 
 * @author ffj
 *
 */
@Controller
@RequestMapping("/dw_mt_manager/db_manager/")
public class DbController {

	@Autowired
	ISrcManagerService iDbManagerService;

	/**
	 * 跳转域名显示页
	 * 
	 * @return
	 */
	@RequestMapping("db_show")
	public String showMi() {
		return "/dw_mt_manager/db_manager/db_show";
	}



}
