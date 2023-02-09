package com.example.springtrainingdemo.aop.util;

import javax.validation.groups.Default;

public interface ValidationGroups  {
    interface create extends Default {
    }

    interface update extends Default {
    }
}
