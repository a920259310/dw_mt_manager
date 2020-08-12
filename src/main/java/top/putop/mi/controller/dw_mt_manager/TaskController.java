package top.putop.mi.controller.dw_mt_manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import top.putop.mi.service.ITaskManagerService;

@Controller
@RequestMapping(value ="/dw_mt_manager/task_manager")
public class TaskController {

    @Autowired
    private ITaskManagerService iTaskManagerService;

    @RequestMapping(value = "/create_hive_table",method = RequestMethod.POST)
    public ModelAndView createHiveTable (@RequestParam("tbId") int tbId,
                                         @RequestParam("taskName") String taskName,
                                         @RequestParam("taskComment") String taskComment){

        ModelAndView mav =new ModelAndView(new MappingJackson2JsonView());
        if(iTaskManagerService.genCreateCodeByTbId(tbId,taskName,taskComment)) {
            mav.addObject("状态","成功");
        }else{
            mav.addObject("状态","失败");
        }
        return mav;
    }

    @RequestMapping(value = "create_import_mysql_shell", method = RequestMethod.POST)
    public ModelAndView createImportMysqlShell(@RequestParam("tbId") int tbId,
                                               @RequestParam("taskName") String taskName,
                                               @RequestParam("taskComment") String taskComment){

        ModelAndView mav =new ModelAndView(new MappingJackson2JsonView());
        if(iTaskManagerService.genMysqlImportCodeByTbId(tbId,taskName,taskComment)){
            mav.addObject("状态","成功");
        }else{
            mav.addObject("状态","失败");
        }
        return mav;
    }

    @RequestMapping(value = "create_import_oracle_shell", method = RequestMethod.POST)
    public ModelAndView createImportOracleShell(@RequestParam("tbId") int tbId,
                                                @RequestParam("taskName") String taskName,
                                                @RequestParam("taskComment") String taskComment){

        ModelAndView mav =new ModelAndView(new MappingJackson2JsonView());
        if(iTaskManagerService.genOracleImportCodeByTbId(tbId, taskName, taskComment)){
            mav.addObject("状态","成功");
        }else{
            mav.addObject("状态","失败");
        }
        return mav;
    }

}
