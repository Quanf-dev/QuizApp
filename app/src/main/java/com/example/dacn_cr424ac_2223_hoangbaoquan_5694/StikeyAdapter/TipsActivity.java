package com.example.dacn_cr424ac_2223_hoangbaoquan_5694.StikeyAdapter;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.R;

import java.util.ArrayList;
import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

public class TipsActivity extends AppCompatActivity {

    private StickyListHeadersListView listTips ;

    private  StickeyAdapter stickeyAdapter ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        listTips = findViewById(R.id.list_tips) ;
        stickeyAdapter = new StickeyAdapter() ;

        stickeyAdapter.setData(getListTips());
        listTips.setAdapter(stickeyAdapter);

    }
    private List<String> getListTips(){
        List<String> list_tips = new ArrayList<>() ;
        list_tips.add("Mẹo B2 câu hỏi về Sa Hình  Thứ tự các xe ưu tiên như sau: Cứu Hỏa -> Quân Sự -> Công An -> Cứu Thương") ;
        list_tips.add("Mẹo B2 câu hỏi về sa hình  Các xe được coi là vào giao lộ khi bánh trước đã vượt qua vạch trắng của người đi bộ ngang đường, dù trong bất kì hoàn cảnh nào thì phương tiện đã vô giao lộ đều được ưu tiên đi trước nhất.") ;
        list_tips.add("Mẹo B2 câu hỏi về sa hình  Trong sa hình này trước mặt xe con là một tấm biển báo hình tam giác ngược – mặc dù không thể thấy nội dung bên trong nhưng ta khẳng định được nội dung của biển “Giao nhau với đường ưu tiên” -> xe ô tô con nằm trên đường không ưu tiên -> phải nhường cho xe mô tô. ") ;
        list_tips.add("Mẹo B2 câu hỏi về sa hình  Vì Việt Nam di chuyển theo phía bên phải -> tay lái thuận ( khác biệt với vài nước đi về bên trái – tay lái nghịch như Nhật Bản, Anh…) nên quyền ưu tiên hướng không có xe được quy định như sau:\n" +
                "\n" +
                "Tại ngã 4 giao lộ: Quyền ưu tiên thuộc về xe nào mà hướng đường bên TAY PHẢI  không có xe.") ;
        list_tips.add("Mẹo B2 câu hỏi về Sa Hình  Tại vòng xoay, vòng xuyến: Quyền ưu tiên thuộc về xe nào mà hướng đường bên TAY TRÁI của nó trống – không có xe.") ;
        list_tips.add("Mẹo B2 câu hỏi về sa hình  Có xe vô giao lộ hay không? Không") ;
        list_tips.add("Mẹo B2 câu hỏi về sa hình  Có xe ưu tiên hay không? Có -> vậy xe ưu tiên (công an) đi đầu tiên.") ;
        list_tips.add("Mẹo B2 câu hỏi về sa hình  Có đường ưu tiên không? Có, vậy xe nào nằm trên đường ưu tiên đi tiếp sau – ở đây là xe tải.") ;
        list_tips.add("Mẹo B2 câu hỏi về sa hình  Bây giờ còn xe khách và xe con, bắt đầu thấy rắc rối rồi đúng không các bạn học viên? Lưu ý là lúc này xe công an và tải đã đi rồi – xuất hiện nguyên tắc thứ 4 – hướng bên phải của xe khách trống -> xe khách đi trước xe con..") ;

        list_tips.add("Mẹo B2 câu hỏi về Biển Báo Biển báo cấm (hình tròn, viền đỏ): biểu thị các điều cấm") ;
        list_tips.add("Mẹo B2 câu hỏi về Biển Báo Biển báo nguy hiểm (hình tam giác vàng, viền đỏ): biểu thị các điều nguy hiểm") ;
        list_tips.add("Mẹo B2 câu hỏi về Biển Báo Biển báo hiệu lệnh (hình tròn xanh, hình vẽ trắng): gặp biển này bắt buộc phải thi hành") ;
        list_tips.add("Mẹo B2 câu hỏi về Biển Báo Biển chỉ dẫn (hình vuông hoặc hình chữ nhật màu xanh, hình vẽ trắng)") ;
        list_tips.add("Mẹo B2 câu hỏi về Biển Báo Thứ tự sắp xếp các loại xe từ nhỏ đến lớn: xe ô tô con → xe ô tô khách → xe ô tô tải → xe máy kéo → xe sơ mi rơ moóc") ;
        list_tips.add("Mẹo B2 câu hỏi về Biển Báo Biển báo cấm xe nhỏ → cấm luôn xe lớn") ;
        list_tips.add("Mẹo B2 câu hỏi về Biển Báo Biển cấm xe ô tô con → cấm luôn xe ba bánh, xe lam") ;
        list_tips.add("Mẹo B2 câu hỏi về Biển Báo Biển cấm xe rẽ trái → cấm luôn xe quay đầu");
        list_tips.add("Mẹo B2 câu hỏi về Biển Báo Ngược lại biển cấm xe quay đầu → xe được phép rẽ trái");
        list_tips.add("Mẹo B2 câu hỏi về Biển Báo Nếu biển màu xanh cho phép xe quay đầu → xe không được phép rẽ trái");
        list_tips.add("Mẹo B2 câu hỏi về Biển Báo Nếu gặp biển \"STOP\" thì tất cả các xe phải dừng lại trong mọi trường hợp kể cả xe ưu tiên");
        list_tips.add("Mẹo B2 câu hỏi về Biển Báo Nếu gặp biển cấm có ghi số 14m thì chọn đáp án không được phép");
        list_tips.add("Mẹo B2 câu hỏi về Biển Báo Nếu biển báo cấm ô tô vượt thì tất cả các loại ôtô đều không được vượt");

        list_tips.add("Mẹo B2 câu hỏi về Lý Thuyết Các câu hỏi trắc nghiệm, quy tắc giao thông\n" +
                "- Đối với các đáp án có những cụm từ sau sẽ luôn đúng, bạn nên chọn ngay:\n" +
                "\n" +
                "“Bị nghiêm cấm” là đáp án đúng\n" +
                "Đáp án bắt đầu bằng cụm từ “Không được…”  là đáp án chính xác\n" +
                "Tuy nhiên, trường hợp đặc biệt là câu 28: “Xe cảnh sát không phát tín hiệu ưu tiên” thì đáp án đúng là “Được vượt khi đảm bảo an toàn”.");
                list_tips.add("Mẹo B2 câu hỏi về Lý Thuyết Các câu hỏi về hạng giấy phép lái xe. " +
                        "\nMẹo vượt qua các câu hỏi này cụ thể như sau:\n" +
                        "\n" +
                        "A1 là xe có phân khối nhỏ hơn 175cc và môtô ba bánh dành cho người khuyết tật.\n" +
                        "A2 là xe có phân khối từ 175cc trở lên.\n" +
                        "A3 là mô tô 3 bánh\n" +
                        "B1 là xe có 9 chỗ ngồi và không hành nghề (xe số tự động)      \n" +
                        "B2 là xe có 9 chỗ ngồi với trọng tải dưới 3,500 kg.\n" +
                        "C là xe đến 9 chỗ ngồi với trọng tải trên 3,500 kg\n" +
                        "D là xe có 30 chỗ ngồi.\n" +
                        "E là xe có 30 chỗ ngồi trở lên.");
                list_tips.add("Mẹo B2 câu hỏi về Lý Thuyết Các câu hỏi liên quan nghiệp vụ vận tải\n" +
                        "Các câu hỏi về nghiệp vụ vận tải nằm ở các trang 53 đến 61, mẹo chọn đáp án cụ thể như sau:\n" +
                        "\n" +
                        "Không được lái xe liên tục trong quá 4 giờ\n" +
                        "Thời gian làm việc của ng lái xe trong ngày chọn “không quá 10 giờ”\n" +
                        "Hàng siêu trường, siêu trọng chọn “không thể tháo rời”\n" +
                        "Hàng nguy hiểm chọn “phải được cấp phép”\n" +
                        "Người kinh doanh vận tải chọn “không được tự ý thay đổi vị trí đón trả khách”");
            list_tips.add("Mẹo B2 câu hỏi về Lý Thuyết Các câu hỏi về tốc độ trong, ngoài khu vực đông dân cư\n" +
                    "- Đối với trường hợp trong đáp án toàn số 40,50,60 km/h và câu hỏi có các cụm từ:\n" +
                    "\n" +
                    "“Xe gắn máy” thì đáp án đúng là 40km/h                         \n" +
                    "“Không có dải phân cách” thì đáp án đúng là 50km/h\n" +
                    "“Có dải phân cách” thì đáp án đúng là 60km/h\n" +
                    "- Đối với các câu hỏi liên quan đến “Đông dân cư”, mẹo ghi nhớ như sau:\n" +
                    "\n" +
                    "Đáp án chứa cụm từ “Ôtô xi téc” là đáp án đúng\n" +
                    "Tất cả đáp án không chứa cụm từ “Ôtô xi téc” thì chọn đáp án dài nhất");
            list_tips.add("Mẹo B2 câu hỏi về Lý Thuyết Các câu hỏi về cự ly tối thiểu giữa các xe\n" +
                    "Các câu hỏi liên quan đến cự ly tối thiểu nằm ở các trang 45, 46. Để chọn đáp án đúng, bạn hãy lấy tốc độ tối đa trừ cho 30, kết quả gần với đáp án nào nhất thì đó là đáp án chính xác. \n" +
                    "\n" +
                    "Ví dụ như “tốc độ từ 60km/h đến 80km/h” thì lấy 80 - 30 = 50, gần đáp án 55m nhất.");
        Log.e("a", String.valueOf(list_tips.get(0).length())) ;



        return list_tips ;
    }
}
