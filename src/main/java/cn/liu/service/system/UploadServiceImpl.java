package cn.liu.service.system;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.liu.util.bean.Ret;

@Service
public class UploadServiceImpl {
	
	public Ret doUpload(MultipartFile file,HttpServletRequest request) {
		Ret ret = new Ret();
		
        try {
        	String fileName = System.currentTimeMillis()+file.getOriginalFilename();
    		String destFileName = request.getServletContext().getRealPath("")+"uploaded"+File.separator+fileName;
    		File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
			file.transferTo(destFile);
			ret.setOk();
		} catch (IllegalStateException e) {
			e.printStackTrace();
			ret.setFail();
			ret.setMessage("上传失败");
		} catch (IOException e) {
			e.printStackTrace();
			ret.setFail();
			ret.setMessage("上传失败");
		}
		return ret;
	}
}
