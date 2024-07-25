
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 出入库
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yaopinChuruInout")
public class YaopinChuruInoutController {
    private static final Logger logger = LoggerFactory.getLogger(YaopinChuruInoutController.class);

    @Autowired
    private YaopinChuruInoutService yaopinChuruInoutService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    // 列表详情的表级联service
    @Autowired
    private YaopinChuruInoutListService yaopinChuruInoutListService;
//    @Autowired
//    private YonghuService yonghuService;
    @Autowired
    private YaopinService yaopinService;
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private YuangongService yuangongService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = yaopinChuruInoutService.queryPage(params);

        //字典表数据转换
        List<YaopinChuruInoutView> list =(List<YaopinChuruInoutView>)page.getList();
        for(YaopinChuruInoutView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YaopinChuruInoutEntity yaopinChuruInout = yaopinChuruInoutService.selectById(id);
        if(yaopinChuruInout !=null){
            //entity转view
            YaopinChuruInoutView view = new YaopinChuruInoutView();
            BeanUtils.copyProperties( yaopinChuruInout , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody YaopinChuruInoutEntity yaopinChuruInout, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yaopinChuruInout:{}",this.getClass().getName(),yaopinChuruInout.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<YaopinChuruInoutEntity> queryWrapper = new EntityWrapper<YaopinChuruInoutEntity>()
            .eq("yaopin_churu_inout_uuid_number", yaopinChuruInout.getYaopinChuruInoutUuidNumber())
            .eq("yaopin_churu_inout_name", yaopinChuruInout.getYaopinChuruInoutName())
            .eq("yaopin_churu_inout_types", yaopinChuruInout.getYaopinChuruInoutTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YaopinChuruInoutEntity yaopinChuruInoutEntity = yaopinChuruInoutService.selectOne(queryWrapper);
        if(yaopinChuruInoutEntity==null){
            yaopinChuruInout.setInsertTime(new Date());
            yaopinChuruInout.setCreateTime(new Date());
            yaopinChuruInoutService.insert(yaopinChuruInout);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YaopinChuruInoutEntity yaopinChuruInout, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,yaopinChuruInout:{}",this.getClass().getName(),yaopinChuruInout.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<YaopinChuruInoutEntity> queryWrapper = new EntityWrapper<YaopinChuruInoutEntity>()
            .notIn("id",yaopinChuruInout.getId())
            .andNew()
            .eq("yaopin_churu_inout_uuid_number", yaopinChuruInout.getYaopinChuruInoutUuidNumber())
            .eq("yaopin_churu_inout_name", yaopinChuruInout.getYaopinChuruInoutName())
            .eq("yaopin_churu_inout_types", yaopinChuruInout.getYaopinChuruInoutTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YaopinChuruInoutEntity yaopinChuruInoutEntity = yaopinChuruInoutService.selectOne(queryWrapper);
        if(yaopinChuruInoutEntity==null){
            yaopinChuruInoutService.updateById(yaopinChuruInout);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }
    /**
    * 出库
    */
    @RequestMapping("/outYaopinChuruInoutList")
    public R outYaopinChuruInoutList(@RequestBody  Map<String, Object> params,HttpServletRequest request){
        logger.debug("outYaopinChuruInoutList方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        String role = String.valueOf(request.getSession().getAttribute("role"));

        //取出入库名称并判断是否存在
        String yaopinChuruInoutName = String.valueOf(params.get("yaopinChuruInoutName"));
        Wrapper<YaopinChuruInoutEntity> queryWrapper = new EntityWrapper<YaopinChuruInoutEntity>()
            .eq("yaopin_churu_inout_name", yaopinChuruInoutName)
            ;
        YaopinChuruInoutEntity yaopinChuruInoutSelectOne = yaopinChuruInoutService.selectOne(queryWrapper);
        if(yaopinChuruInoutSelectOne != null)
            return R.error(511,"出入库名称已被使用");


    //取当前表的级联表并判断是否前台传入

        Map<String, Integer> map = (Map<String, Integer>) params.get("map");
        if(map == null || map.size() == 0)
            return R.error(511,"列表内容不能为空");


        Set<String> ids = map.keySet();

        List<YaopinEntity> yaopinList = yaopinService.selectBatchIds(ids);
        if(yaopinList == null || yaopinList.size() == 0){
            return R.error(511,"查数据库查不到数据");
        }else{
            for(YaopinEntity w:yaopinList){
                Integer value = w.getYaopinKucunNumber()-map.get(String.valueOf(w.getId()));
                if(value <0){
                    return R.error(511,"出库数量大于库存数量");
                }
                w.setYaopinKucunNumber(value);
            }
        }

        //当前表
        YaopinChuruInoutEntity yaopinChuruInoutEntity = new YaopinChuruInoutEntity<>();
            yaopinChuruInoutEntity.setYaopinChuruInoutUuidNumber(String.valueOf(new Date().getTime()));
            yaopinChuruInoutEntity.setYaopinChuruInoutName(yaopinChuruInoutName);
            yaopinChuruInoutEntity.setYaopinChuruInoutTypes(1);
            yaopinChuruInoutEntity.setYaopinChuruInoutContent("");
            yaopinChuruInoutEntity.setInsertTime(new Date());
            yaopinChuruInoutEntity.setCreateTime(new Date());

        boolean insertYaopinChuruInout = yaopinChuruInoutService.insert(yaopinChuruInoutEntity);
        if(insertYaopinChuruInout){
            //级联表
            ArrayList<YaopinChuruInoutListEntity> yaopinChuruInoutLists = new ArrayList<>();
            for(String id:ids){
                YaopinChuruInoutListEntity yaopinChuruInoutListEntity = new YaopinChuruInoutListEntity();
                    yaopinChuruInoutListEntity.setYaopinChuruInoutId(yaopinChuruInoutEntity.getId());
                    yaopinChuruInoutListEntity.setYaopinId(Integer.valueOf(id));
                    yaopinChuruInoutListEntity.setYaopinChuruInoutListNumber(map.get(id));
                    yaopinChuruInoutListEntity.setInsertTime(new Date());
                    yaopinChuruInoutListEntity.setCreateTime(new Date());
                yaopinChuruInoutLists.add(yaopinChuruInoutListEntity);
                yaopinService.updateBatchById(yaopinList);
            }
            yaopinChuruInoutListService.insertBatch(yaopinChuruInoutLists);
        }
        return R.ok();
    }

    /**
    *入库
    */
    @RequestMapping("/inYaopinChuruInoutList")
    public R inYaopinChuruInoutList(@RequestBody  Map<String, Object> params,HttpServletRequest request){
        logger.debug("inYaopinChuruInoutList方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        //params:{"map":{"1":2,"2":3},"wuziOutinName":"订单1"}

        String role = String.valueOf(request.getSession().getAttribute("role"));

        //取当前表名称并判断
        String yaopinChuruInoutName = String.valueOf(params.get("yaopinChuruInoutName"));
        Wrapper<YaopinChuruInoutEntity> queryWrapper = new EntityWrapper<YaopinChuruInoutEntity>()
            .eq("yaopin_churu_inout_name", yaopinChuruInoutName)
            ;
        YaopinChuruInoutEntity yaopinChuruInoutSelectOne = yaopinChuruInoutService.selectOne(queryWrapper);
        if(yaopinChuruInoutSelectOne != null)
            return R.error(511,"出入库名称已被使用");


        //取当前表的级联表并判断是否前台传入

        Map<String, Integer> map = (Map<String, Integer>) params.get("map");
        if(map == null || map.size() == 0)
            return R.error(511,"列表内容不能为空");

        Set<String> ids = map.keySet();

        List<YaopinEntity> yaopinList = yaopinService.selectBatchIds(ids);
        if(yaopinList == null || yaopinList.size() == 0){
            return R.error(511,"查数据库查不到数据");
        }else{
            for(YaopinEntity w:yaopinList){
                w.setYaopinKucunNumber(w.getYaopinKucunNumber()+map.get(String.valueOf(w.getId())));
            }
        }

        //当前表
        YaopinChuruInoutEntity yaopinChuruInoutEntity = new YaopinChuruInoutEntity<>();
            yaopinChuruInoutEntity.setYaopinChuruInoutUuidNumber(String.valueOf(new Date().getTime()));
            yaopinChuruInoutEntity.setYaopinChuruInoutName(yaopinChuruInoutName);
            yaopinChuruInoutEntity.setYaopinChuruInoutTypes(2);
            yaopinChuruInoutEntity.setYaopinChuruInoutContent("");
            yaopinChuruInoutEntity.setInsertTime(new Date());
            yaopinChuruInoutEntity.setCreateTime(new Date());


        boolean insertYaopinChuruInout = yaopinChuruInoutService.insert(yaopinChuruInoutEntity);
        if(insertYaopinChuruInout){
            //级联表
            ArrayList<YaopinChuruInoutListEntity> yaopinChuruInoutLists = new ArrayList<>();
            for(String id:ids){
                YaopinChuruInoutListEntity yaopinChuruInoutListEntity = new YaopinChuruInoutListEntity();
                yaopinChuruInoutListEntity.setYaopinChuruInoutId(yaopinChuruInoutEntity.getId());
                yaopinChuruInoutListEntity.setYaopinId(Integer.valueOf(id));
                yaopinChuruInoutListEntity.setYaopinChuruInoutListNumber(map.get(id));
                yaopinChuruInoutListEntity.setInsertTime(new Date());
                yaopinChuruInoutListEntity.setCreateTime(new Date());
                yaopinChuruInoutLists.add(yaopinChuruInoutListEntity);
                yaopinService.updateBatchById(yaopinList);
            }
            yaopinChuruInoutListService.insertBatch(yaopinChuruInoutLists);
        }

        return R.ok();
    }
    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        yaopinChuruInoutService.deleteBatchIds(Arrays.asList(ids));
        yaopinChuruInoutListService.delete(new EntityWrapper<YaopinChuruInoutListEntity>().in("yaopin_churu_inout_id",ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<YaopinChuruInoutEntity> yaopinChuruInoutList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            YaopinChuruInoutEntity yaopinChuruInoutEntity = new YaopinChuruInoutEntity();
//                            yaopinChuruInoutEntity.setYaopinChuruInoutUuidNumber(data.get(0));                    //出入库流水号 要改的
//                            yaopinChuruInoutEntity.setYaopinChuruInoutName(data.get(0));                    //出入库名称 要改的
//                            yaopinChuruInoutEntity.setYaopinChuruInoutTypes(Integer.valueOf(data.get(0)));   //出入库类型 要改的
//                            yaopinChuruInoutEntity.setYaopinChuruInoutContent("");//详情和图片
//                            yaopinChuruInoutEntity.setInsertTime(date);//时间
//                            yaopinChuruInoutEntity.setCreateTime(date);//时间
                            yaopinChuruInoutList.add(yaopinChuruInoutEntity);


                            //把要查询是否重复的字段放入map中
                                //出入库流水号
                                if(seachFields.containsKey("yaopinChuruInoutUuidNumber")){
                                    List<String> yaopinChuruInoutUuidNumber = seachFields.get("yaopinChuruInoutUuidNumber");
                                    yaopinChuruInoutUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> yaopinChuruInoutUuidNumber = new ArrayList<>();
                                    yaopinChuruInoutUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("yaopinChuruInoutUuidNumber",yaopinChuruInoutUuidNumber);
                                }
                        }

                        //查询是否重复
                         //出入库流水号
                        List<YaopinChuruInoutEntity> yaopinChuruInoutEntities_yaopinChuruInoutUuidNumber = yaopinChuruInoutService.selectList(new EntityWrapper<YaopinChuruInoutEntity>().in("yaopin_churu_inout_uuid_number", seachFields.get("yaopinChuruInoutUuidNumber")));
                        if(yaopinChuruInoutEntities_yaopinChuruInoutUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YaopinChuruInoutEntity s:yaopinChuruInoutEntities_yaopinChuruInoutUuidNumber){
                                repeatFields.add(s.getYaopinChuruInoutUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [出入库流水号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        yaopinChuruInoutService.insertBatch(yaopinChuruInoutList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
