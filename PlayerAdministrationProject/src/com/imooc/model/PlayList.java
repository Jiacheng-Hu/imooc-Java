package com.imooc.model;

import java.util.ArrayList;
import java.util.List;

public class PlayList {

	private String playListName;
	private List<Song> musicList = new ArrayList<Song>();

	public PlayList() {

	}

	public PlayList(String playListName) {
		this.setPlayListName(playListName);
	}

	public String getPlayListName() {
		return playListName;
	}

	public void setPlayListName(String playListName) {
		this.playListName = playListName;
	}

	public List<Song> getMusicList() {
		return musicList;
	}
	
	public void addToPlayList(Song song) {
		musicList.add(song);
	}
	
	public void displayAllSong() {
		System.out.println("播放列表中的所有歌曲为：");
		for(int i = 0; i < musicList.size(); i++) {
			System.out.println(musicList.get(i));
		}
	}
	
	public Song searchSongById(String id) {
		Song temp = null;
		for(int i = 0; i < musicList.size(); i++) {
			if(musicList.get(i).getId().equals(id)) {
				temp = musicList.get(i);
				break;
			}
		}
		return temp;
	}
	
	public Song searchSongByName(String name) {
		Song temp = null;
		for(int i = 0; i < musicList.size(); i++) {
			if(musicList.get(i).getName().equals(name)) {
				temp = musicList.get(i);
				break;
			}
		}
		return temp;
	}
	
	public void updateSong(String id, Song song) {
		for(int i = 0; i < musicList.size(); i++) {
			if(musicList.get(i).getId().equals(id)) {
				musicList.remove(i);
				musicList.add(i, song);
			}
		}
	}
	
	public void deleteSong(String id) {
		for(int i = 0; i < musicList.size(); i++) {
			if(musicList.get(i).getId().equals(id)) {
				musicList.remove(i);
			}
		}
	}

}
