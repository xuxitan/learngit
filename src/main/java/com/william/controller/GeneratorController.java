package com.william.controller;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.william.common.Constant;
import com.william.exception.CustomException;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther:xuxitan
 * @Date: 2018/8/7 13:57
 * @Description:
 */
@RestController
public class GeneratorController {


    /**
     * 自动生成代码
     * @param globalConfig
     * @param dataSourceConfig
     * @param strategyConfig
     * @param packageConfig
     * @return
     * @throws CustomException
     */
    @RequestMapping(value = "generator",method = RequestMethod.POST)
    public String generator(GlobalConfig globalConfig, DataSourceConfig dataSourceConfig,StrategyConfig strategyConfig, PackageConfig packageConfig) throws CustomException {
        //
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = customFileName(globalConfig);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = customDataSourceConfig(dataSourceConfig);
        mpg.setDataSource(dsc);

        //策略配置
        StrategyConfig strategy = customStrategyConfig(strategyConfig);
        mpg.setStrategy(strategy);

        //包配置
        mpg.setPackageInfo(packageConfig);

        TemplateConfig tc = new TemplateConfig();
        tc.setController("/template/controller.java.vm");
        tc.setEntity("/template/Entity.java.vm");
        tc.setMapper("/template/mapper.java.vm");
        tc.setXml("/template/mapper.xml.vm");
        tc.setService("/template/service.java.vm");
        tc.setServiceImpl("/template/serviceImpl.java.vm");
        // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
        mpg.setTemplate(tc);

        // 执行生成
        mpg.execute();

        return "";
    }

    /**
     * 自定义策略配置
     * @param strategy
     * @return
     */
    private StrategyConfig customStrategyConfig(StrategyConfig strategy) {

        // 表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);

        return strategy;
    }

    /**
     * 自定义文件命名
     */
    private GlobalConfig customFileName(GlobalConfig gc) {

        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        // XML 二级缓存
        gc.setEnableCache(false);
        // XML ResultMap
        gc.setBaseResultMap(true);
        // XML columList
        gc.setBaseColumnList(true);

        // %s 会自动填充表实体属性！
        String suffix = "%s";
        if (StringUtils.isNotEmpty(gc.getOutputDir())) {
            //生成文件的位置
            gc.setOutputDir(gc.getOutputDir());
        }
        if (StringUtils.isNotEmpty(gc.getAuthor())) {
            // 作者
            gc.setAuthor(gc.getAuthor());
        }
        if (StringUtils.isNotEmpty(gc.getMapperName())) {
            gc.setMapperName(suffix + gc.getMapperName());
        }
        if (StringUtils.isNotEmpty(gc.getXmlName())) {
            gc.setXmlName(suffix + gc.getXmlName());
        }
        if (StringUtils.isNotEmpty(gc.getServiceName())) {
            gc.setServiceName(suffix + gc.getServiceName());
        }
        if (StringUtils.isNotEmpty(gc.getServiceImplName())) {
            gc.setServiceImplName(suffix + gc.getServiceImplName());
        }
        if (StringUtils.isNotEmpty(gc.getControllerName())) {
            gc.setControllerName(suffix + gc.getControllerName());
        }
        return gc;
    }


    /**
     * 数据库参数设置
     */
    private DataSourceConfig customDataSourceConfig(DataSourceConfig dsc) throws CustomException {
        // 数据源配置
        //目前支持MYSQL,后期扩展
        dsc.setDbType(DbType.MYSQL);

        dsc.setTypeConvert(new MySqlTypeConvert() {
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
                return super.processTypeConvert(fieldType);
            }
        });

        dsc.setDriverName(Constant.MYSQL_DRIVER_NAME);

        if (StringUtils.isEmpty(dsc.getUsername())) {
            throw new CustomException("500101", "用户名不能为空");
        }

        if (StringUtils.isNotEmpty(dsc.getPassword())) {
            dsc.setUsername(dsc.getPassword());
        }

        if (StringUtils.isNotEmpty(dsc.getUrl())) {
            if (dsc.getUrl().contains("?")) {
                dsc.setUsername(dsc.getUrl());
            } else {
                dsc.setUrl(dsc.getUrl() + "?useUnicode=true&characterEncoding=UTF-8");
            }
        }
        return dsc;
    }
}
