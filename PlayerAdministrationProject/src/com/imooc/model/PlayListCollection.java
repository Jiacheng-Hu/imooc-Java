package com.imooc.model;

import java.util.HashMap;
import java.util.Map;

public class PlayListCollection {
	
	private Map<String, PlayList> playListMap = new HashMap<String, PlayList>();
	private PlayList mainPlayList = null;
	
	public PlayListCollection() {
		mainPlayList = new PlayList("主播放列表");
		addPlayList(mainPlayList);
	}

	public Map<String, PlayList> getPlayListMap() {
		return playListMap;
	}
	
	public void addPlayList(PlayList playList) {
		playListMap.put(playList.getPlayListName(), playList);
	}
	
	public void deletePlayList(PlayList playList) {
		playListMap.remove(playList.getPlayListName());
	}
	
	public PlayList searchPlayListByName(String name) {
		PlayList temp = playListMap.get(name);
		return temp;
	}
	
	public void displayPlayListName() {
		System.out.println("所有播放列表的名称为：");
		for(String s : playListMap.keySet()) {
			System.out.println(s);
		}
	}

}
