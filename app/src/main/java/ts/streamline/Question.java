package ts.streamline;

import org.joda.time.DateTime;

/**
 * Created by CrystalJ on 14/09/2014.
 */
public class Question {
    private Integer ListingId;
    private Integer ListingQuestionId;
    private String Comment;
    private DateTime CommentDate;
    private String Answer;
    private DateTime AnswerDate;
    private boolean IsSellerComment;
    private Member AskingMember;

    public Question(Integer listingId, Integer listingQuestionId, String comment, DateTime commentDate, String answer, DateTime answerDate, boolean isSellerComment, Member askingMember) {
        ListingId = listingId;
        ListingQuestionId = listingQuestionId;
        Comment = comment;
        CommentDate = commentDate;
        Answer = answer;
        AnswerDate = answerDate;
        IsSellerComment = isSellerComment;
        AskingMember = askingMember;
    }

    public Integer getListingId() {
        return ListingId;
    }

    public Integer getListingQuestionId() {
        return ListingQuestionId;
    }

    public String getComment() {
        return Comment;
    }

    public DateTime getCommentDate() {
        return CommentDate;
    }

    public String getAnswer() {
        return Answer;
    }

    public DateTime getAnswerDate() {
        return AnswerDate;
    }

    public boolean isSellerComment() {
        return IsSellerComment;
    }

    public Member getAskingMember() {
        return AskingMember;
    }
}
