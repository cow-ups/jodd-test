package com.cowups.web.config;

import jodd.madvoc.WebApp;
import jodd.madvoc.petite.PetiteWebApp;
import jodd.petite.AutomagicPetiteConfigurator;
import jodd.petite.PetiteContainer;

/**
 * @Author: Ma_guowei
 * @Date: 2018-09-11
 * @Description: 容器初始化时添加自动注入
 **/
public class WebAppConfig  extends PetiteWebApp {

    private static final PetiteContainer petiteContainer;

    static {
        petiteContainer = new PetiteContainer();
        AutomagicPetiteConfigurator pcfg = new AutomagicPetiteConfigurator(petiteContainer);
        pcfg.configure();
    }

    public WebAppConfig(){
        this(petiteContainer);
    }
    public WebAppConfig(PetiteContainer petiteContainer) {
        super(petiteContainer);
    }

    @Override
    protected void registerMadvocComponents() {
        super.registerMadvocComponents();
//        initPetite();
        // TODO 可以添加初始化需要加载配置信息等
        // config()...
    }

    /*private void initPetite() {
        PetiteContainer petiteContainer = new PetiteContainer();
        AutomagicPetiteConfigurator pcfg = new AutomagicPetiteConfigurator(petiteContainer);
        pcfg.configure();
    }*/

    @Override
    public void shutdown(){
        super.shutdown();
    }
}
