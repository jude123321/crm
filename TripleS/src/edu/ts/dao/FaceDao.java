package edu.ts.dao;

public interface FaceDao {
    /**
     * 获取url图片的faceId
     *
     * @param url 图片地址
     * @return faceId
     */
    public String detectFace(String url);

    /**
     * 识别人脸
     *
     * @param personGroupId person group id
     * @param faceId
     * @return personId
     */
    public String identifyFace(String personGroupId,String faceId);

}
