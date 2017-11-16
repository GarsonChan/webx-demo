package webx.app1.module.action.pipeline;

import com.alibaba.citrus.service.pipeline.PipelineContext;
import com.alibaba.citrus.service.pipeline.Valve;

/**
 * Created by Garson in 20:16 2017/11/13
 * Description : 自定义valve，可以进行权限管理等
 */
public class MyValve implements Valve {

	@Override
	public void invoke(PipelineContext pipelineContext) throws Exception {
		System.out.println("valve start");
		pipelineContext.invokeNext();
		System.out.println("valve end");
	}
}
