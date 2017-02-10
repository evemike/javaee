'use strict';

describe('Service: klass', function() {

    // load the service's module
    beforeEach(module('webAppApp'));

    // instantiate service
    var klass, $httpBackend, config;
    beforeEach(inject(function(_klass_, _$httpBackend_, _config_) {
        klass = _klass_;
        config = _config_;      // 引用项目配置
        config.isDebug = false; // 关闭开发模式
        $httpBackend = _$httpBackend_;

        // 定义请求 URL
        var url = config.apiRootPath + '/Klass.json';
        // 定义返回数据, 仅定义正确的返回码。
        var data = {code:200};

        // 进行模似数据请求配置.当请求方法为post，资源名为url时, 返回data数据.
        $httpBackend.when('POST', url).respond(data);

        // 定义请求 URL
        url = config.apiRootPath + '/klass.Save.json';
        // 定义返回数据, 仅定义正确的返回码。

        // 进行模似数据请求配置.当请求方法为post，资源名为url时, 返回data数据.
        $httpBackend.when('POST', url).respond(data);

        // 增加GET的测试
        url = config.apiRootPath + '/klass.Get.json?id=1';
        $httpBackend.when('GET', url).respond(data);

        // 增加update测试
        url = config.apiRootPath + '/klass.Update.json';
        $httpBackend.when('POST', url).respond(data);

    }));

    it('检测语法是否出现错误', function() {
        // 调用方法
        klass.paginate('', 1, 2, function() {
            console.log('klass paginate passed');
        });

        // 调用保存
        klass.save({name:'name', teacherId:3}, function(){
            console.log('klass save 通过');
        });

        // 调用GET
        klass.get(1, function(){
            console.log('klass get 通过');
        });

        // 调用UPDATE
        klass.update({}, function(){
            console.log('klass update 通过');
        });
        // 模拟数据请求
        $httpBackend.flush();
    });

});
