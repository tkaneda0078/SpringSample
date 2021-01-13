package com.example.demo.login.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.demo.login.domain.model.User;

public interface UserDao {
	// userテーブルの件数を取得する
	public int count() throws DataAccessException;

	// userテーブルにデータを1件作成する
	public int createOne(User user) throws DataAccessException;

	// userテーブルのデータを1件取得する
	public User getOne(String userId) throws DataAccessException;

	// userテーブルの全データを取得する
	public List<User> getAll() throws DataAccessException;

	// userテーブルを１件更新
	public int updateOne(User user) throws DataAccessException;

	// userテーブルを１件削除
	public int deleteOne(String userId) throws DataAccessException;

	// SQL取得結果をサーバーにCSVで保存する
	public void userCsvOut() throws DataAccessException;
}
