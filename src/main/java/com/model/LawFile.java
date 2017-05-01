package com.model;

public class LawFile {
    private Integer fileId;

    private String fileName;

    private String createPeople;

    private String FileContent;
    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getCreatePeople() {
        return createPeople;
    }

    public void setCreatePeople(String createPeople) {
        this.createPeople = createPeople == null ? null : createPeople.trim();
    }

    public String getFileContent() {
        return FileContent;
    }

    public void setFileContent(String fileContent) {
        FileContent = fileContent;
    }
}