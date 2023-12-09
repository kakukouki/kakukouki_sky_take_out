package com.sky.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.sky.enumeration.OperationType;

/**
 * 自動的に機能フィールドを埋める必要があるメソッドを識別するためのカスタムアノテーションを作成します。
 * 
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFill {
	//データベース操作のタイプ：INSERT，UPDATE
	OperationType value(); 
}
