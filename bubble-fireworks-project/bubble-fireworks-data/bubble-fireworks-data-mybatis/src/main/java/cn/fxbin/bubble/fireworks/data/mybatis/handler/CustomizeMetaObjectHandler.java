package cn.fxbin.bubble.fireworks.data.mybatis.handler;

import cn.fxbin.bubble.fireworks.core.util.time.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * CustomizeMetaObjectHandler
 *
 * @author fxbin
 * @version v1.0
 * @since 2020/11/23 10:53
 */
@Slf4j
@Component
public class CustomizeMetaObjectHandler implements com.baomidou.mybatisplus.core.handlers.MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, DateUtils.localDateTime());

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, DateUtils.localDateTime());
    }
}
