package com.nationsky.base.handler;

import com.alibaba.fastjson.JSON;
import com.nationsky.base.builder.AbstractBuilder;
import com.nationsky.base.builder.ImageBuilder;
import com.nationsky.base.builder.TextBuilder;
import com.nationsky.base.dto.WxMenuKey;
import com.nationsky.base.service.WeixinService;

import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

import org.springframework.stereotype.Component;

import java.util.Map;

import static me.chanjar.weixin.common.api.WxConsts.XmlMsgType;

/**
 * 
 * @author Binary Wang
 *
 */
@Component
public class MenuHandler extends AbstractHandler {


  public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
      Map<String, Object> context, WxMpService wxMpService,
      WxSessionManager sessionManager) {
    WeixinService weixinService = (WeixinService) wxMpService;

    String key = wxMessage.getEventKey();
    WxMenuKey menuKey;
    try {
      menuKey = JSON.parseObject(key, WxMenuKey.class);
    } catch (Exception e) {
      return WxMpXmlOutMessage.TEXT().content(key)
          .fromUser(wxMessage.getToUser())
          .toUser(wxMessage.getFromUser()).build();
    }

    AbstractBuilder builder = null;
    switch (menuKey.getType()) {
    case XmlMsgType.TEXT:
      builder = new TextBuilder();
      break;
    case XmlMsgType.IMAGE:
      builder = new ImageBuilder();
      break;
    case XmlMsgType.VOICE:
      break;
    case XmlMsgType.VIDEO:
      break;
    case XmlMsgType.NEWS:
      break;
    default:
      break;
    }

    if (builder != null) {
      try {
        return builder.build(menuKey.getContent(), wxMessage, weixinService);
      } catch (Exception e) {
        this.logger.error(e.getMessage(), e);
      }
    }

    return null;

  }

}
