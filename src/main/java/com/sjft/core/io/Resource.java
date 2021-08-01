package com.sjft.core.io;

import java.io.IOException;
import java.io.InputStream;

public interface Resource {

    /**
     * 获取资源加载流
     * @return
     * @throws IOException
     */
    InputStream getInputStream() throws IOException;
}
