package cn.liu.controller.system;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.liu.service.system.UploadServiceImpl;
import cn.liu.util.bean.Ret;

/**
 * 上传相关的控制器
 * @author liu
 */
@Controller
@RequestMapping("/upload")
public class UploadController {
	@Autowired UploadServiceImpl uploadService;
	
	@RequestMapping("/page")
	public String index() {
		return "upload";
	}
	@RequestMapping(value = "/doUpload",method = RequestMethod.POST)
	@ResponseBody
	public Ret doUpload(@RequestParam("file") MultipartFile file,HttpServletRequest request) {
		return uploadService.doUpload(file, request);
	}
}
