package top.putop.mi.controller.dw_mt_manager;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.putop.mi.db.model.MiMessage;
import top.putop.mi.service.IDbManagerService;

import javax.websocket.server.PathParam;
import java.util.Iterator;
import java.util.List;

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
	IDbManagerService iDbManagerService;

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
