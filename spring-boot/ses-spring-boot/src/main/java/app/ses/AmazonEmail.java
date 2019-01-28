package app.ses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmazonEmail {

    private List<String> to;
    private List<String> cc;
    private List<String> bcc;
    private SESFrom from;
    private String subject;
    private String body;
    private boolean html;
    private List<AmazonAttachment> files;

    public AmazonEmail() {
        this.to = new ArrayList<>();
        this.cc = new ArrayList<>();
        this.bcc = new ArrayList<>();
        this.from = SESFrom.NO_REPLY;
        this.files = new ArrayList<>();
        this.html = true;
    }

    public AmazonEmail(String to, String subject, String body) {
        this.to = new ArrayList<>();
        this.to.add(to);
        this.subject = subject;
        this.body = body;
        this.html = true;
        this.files = new ArrayList<>();
        this.from = SESFrom.NO_REPLY;
        this.cc = new ArrayList<>();
        this.bcc = new ArrayList<>();
    }

    public AmazonEmail(String to, SESFrom from, String subject, String body) {
        this.to = new ArrayList<>();
        this.to.add(to);
        this.from = from;
        this.subject = subject;
        this.body = body;
        this.html = true;
        this.files = new ArrayList<>();
        this.cc = new ArrayList<>();
        this.bcc = new ArrayList<>();
    }

    public AmazonEmail(String to, SESFrom from, String subject, String body, List<String> cc) {
        this.to = new ArrayList<>();
        this.to.add(to);
        this.from = from;
        this.subject = subject;
        this.body = body;
        this.cc = cc;
        this.html = true;
        this.files = new ArrayList<>();
        this.bcc = new ArrayList<>();
    }

    public AmazonEmail(String to, SESFrom from, String subject, String body, List<String> cc, List<String> bcc) {
        this.to = new ArrayList<>();
        this.to.add(to);
        this.from = from;
        this.subject = subject;
        this.body = body;
        this.cc = cc;
        this.bcc = bcc;
        this.html = true;
        this.files = new ArrayList<>();
    }

    public AmazonEmail(List<String> to, String subject, String body) {
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.html = true;
        this.files = new ArrayList<>();
        this.from = SESFrom.NO_REPLY;
        this.cc = new ArrayList<>();
        this.bcc = new ArrayList<>();
    }

    public AmazonEmail(List<String> to, SESFrom from, String subject, String body) {
        this.to = to;
        this.from = from;
        this.subject = subject;
        this.body = body;
        this.html = true;
        this.files = new ArrayList<>();
        this.cc = new ArrayList<>();
        this.bcc = new ArrayList<>();
    }

    public AmazonEmail(List<String> to, String subject, String body, boolean html) {
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.html = html;
        this.files = new ArrayList<>();
        this.from = SESFrom.NO_REPLY;
        this.cc = new ArrayList<>();
        this.bcc = new ArrayList<>();
    }

    public AmazonEmail(List<String> to, SESFrom from, String subject, String body, boolean html) {
        this.to = to;
        this.from = from;
        this.subject = subject;
        this.body = body;
        this.html = html;
        this.cc = new ArrayList<>();
        this.bcc = new ArrayList<>();
    }

    public AmazonEmail(List<String> to, SESFrom from, String subject, String body, boolean html, List<AmazonAttachment> files) {
        this.to = to;
        this.from = from;
        this.subject = subject;
        this.body = body;
        this.html = html;
        this.files = files;
        this.cc = new ArrayList<>();
        this.bcc = new ArrayList<>();
    }

    public List<String> getTo() {
        return to;
    }

    public void setTo(List<String> to) {
        this.to = to;
    }

    public void setTo(String... to) {
        this.to = new ArrayList<>();
        this.to.addAll(Arrays.asList(to));
    }

    public List<String> getCc() {
        return cc;
    }

    public void setCc(List<String> cc) {
        this.cc = cc;
    }

    public void setCc(String... cc) {
        this.cc = new ArrayList<>();
        this.cc.addAll(Arrays.asList(cc));
    }

    public List<String> getBcc() {
        return bcc;
    }

    public void setBcc(List<String> bcc) {
        this.bcc = bcc;
    }

    public void setBcc(String... bcc) {
        this.bcc = new ArrayList<>();
        this.bcc.addAll(Arrays.asList(bcc));
    }

    public String getFrom() {
        return String.format("\"%s\" <%s>", from.getName(), from.getEmail());
    }

    public void setFrom(SESFrom from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isHtml() {
        return html;
    }

    public void setHtml(boolean html) {
        this.html = html;
    }

    public List<AmazonAttachment> getFiles() {
        return files;
    }

    public void setFiles(List<AmazonAttachment> files) {
        this.files = files;
    }

    public void setFiles(AmazonAttachment... files) {
        this.files = new ArrayList<>();
        this.files.addAll(Arrays.asList(files));
    }
}
