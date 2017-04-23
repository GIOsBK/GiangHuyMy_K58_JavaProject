package com.example.sandwraith8.java_project.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

import android.databinding.DataBindingUtil;

import com.example.sandwraith8.java_project.R;
import com.example.sandwraith8.java_project.common.Constant;
import com.example.sandwraith8.java_project.databinding.ActivityMainBinding;
import com.example.sandwraith8.java_project.features.display.folders.DisplayFolderPresenter;
import com.example.sandwraith8.java_project.features.display.folders.DisplayFolderView;

public class MainActivity extends AppCompatActivity implements DisplayFolderView {

    private ActivityMainBinding mBinding;

    private DisplayFolderPresenter mDisplayFolderPresenter;
    private SharedPreferences settings;
    final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mDisplayFolderPresenter = new DisplayFolderPresenter(this);
        mDisplayFolderPresenter.makeRootFolder();

        settings = getSharedPreferences(PREFS_NAME, 0);
        if (settings.getBoolean("my_first_time", true)) {
            File folder = new File(Environment.getExternalStorageDirectory() +
                    File.separator + Constant.DIRECTORY + "/demo");
            if (!folder.exists())
                folder.mkdirs();
            try {
                Writer writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(Environment.getExternalStorageDirectory() +
                                File.separator + Constant.DIRECTORY + "/demo/demo.txt"), "utf-8"));
                writer.write("Mộc Kiếm Bình gieo vạ tổng binh<br/>\t\t\t\t\t\t   Vi Tiểu Bảo tỏ vẻ khó chịu hỏi:<br/>- Hạ tổng binh chỉ tìm cớ thoái thác, trong vụ này có điều chi bí<br/>ẩn? Phải chăng tổng binh còn muốn dở trò mạt cưa mướp đắng để lừa gạt bản<br/>nhân? Tổng binh cứ đem y ra đây cho bản nhân coi, thử xem bản nhân có giải<br/>quyết được không?<br/>Gã thấy ý trung nhân bị bắt và lâm vào tình trạng dữ nhiều lành ít, nên trong<br/>dạ rất đỗi bồn chồn, thốt ra những câu cạn tàu ráo máng. Bộ mặt nghiêm nghị giả<br/>dối bên ngoài của giới quan trường để tụt mất.<br/>Hạ Quốc Tương vội đáp:<br/>- Khi nào tiểu tướng dám bịp bợm đô thống đại nhân? Chỉ vì⬢ chỉ vì trong<br/>vụ này thật tình có điều khó xử.<br/>Vi Tiểu Bảo xưng giọng hỏi:<br/>- Làm sao mà khó xử?<br/>Hạ Quốc Tương đáp:<br/>- Vương gia của bọn tiểu tướng trị người rất nghiêm khắc. Tiểu tướng là nữ tế<br/>của lão nhân gia, nên lão nhân gia đối đãi với tiểu tướng là nữ tế của lão nhân gia,<br/>nên lão nhân gia đối đãi với tiểu tướng càng nghiêm ngặt hơn để tránh bọn thuộc<br/>hạ nói lén là lão nhân gia bất công.<br/>Vi Tiểu Bảo mỉm cười nói:<br/>- Làm chú rể này khó thật! Bản nhân nghe nói Trần Viên Viên, vương phi của<br/>vương gia là đệ nhất mỹ nhân trong thiên hạ. Trần vương phi lại có mối liên quan<br/>đến việc nhà Đại Thanh ta lấy được giang sơn này. Trượng mẫu của của tổng binh<br/>đã có tấm dung nhan hoa nhường nguyệt thẹn thì bà vợ của tổng binh dĩ nhiên<br/>cũng nhan sắc cá lặn nhạn sa. Làm rể đã là chuyện khó, muốn làm rể cho đắc lực<br/>lại càng khó hơn. Chú rể dòm ngó mẹ vợ nhiều lần rồi bị bố vợ đét vào đít là<br/>chuyện thường.<br/>Hạ Quốc Tương đáp:<br/>- Tiện thê của tiểu tướng...<br/>Vi Tiểu Bảo đang nói đến chỗ cao hứng, không chờ đối phương nói hết đã<br/>cướp lời:<br/>- Người ta thường nói \"Mẹ vợ thấy chàng rể dòng châu nhỏ giọt\". Ta coi bộ<br/>tổng binh có bà mẹ vợ đẹp như vậy thì câu đó phải đổi ngược lại \"Chàng rể thấy<br/>mẹ vợ nuốt nước miếng ừng ực\". Ha ha! Ha ha!...<br/>Hạ Quốc Tương bẽn lẽn mắng thầm:<br/>- Thằng lỏi này nói nhăng nói càn, rõ phường lưu manh ở nơi đầu đường xó<br/>chợ, chẳng ra thể thống quan đại thần chút nào.<br/>Ngoài miệng hắn đáp:<br/>- Tiện thê không phải là con ruột của Trần vương phi.<br/>Vi Tiểu Bảo thở dài nói:<br/>- Nếu vậy thật là đáng tiếc! Đáng tiếc! Vận khí của tổng binh xúi quá.<br/>Đột nhiên gã sa sầm nét mặt lớn tiếng:<br/>- Ta muốn thẩm vấn thích khách mà sao ngươi đưa toàn chuyện không đâu, nói<br/>giằng sang cả chuyện mẹ vợ? Chà chà! Thế này thi thật là quái gở!<br/>Hạ Quốc Tương trong lòng càng tức giận, nhưng ngoài mặt hắn vẫn giữ vẻ<br/>cung kính đáp:<br/>- Được đô thống đại nhân đến thẩm vấn thích khác thì còn gì hay hơn nữa?<br/>Đô thống đại nhân hỏi một câu, còn hơn bọn tiểu tướng hỏi hàng trăm hàng ngàn<br/>câu. Nhưng chỉ sợ vương gia... vương gia...<br/>Vi Tiểu Bảo tức giận quát hỏi:<br/>- Vương gia làm sao? Lão nhân gia không cho ta thẩm vấn thích khách chăng?<br/>Hạ Quốc Tương vội đáp:<br/>- Không phải thế! Không phải thế! Đô thống đại nhân đừng hiểu lầm. Đại<br/>nhân đến coi thích khách để điều tra cho biết rõ lai lịch người con gái kia thì<br/>vương gia của bọn tiểu tướng chỉ có phần cảm kích, quyết chẳng khi nào ngăn trở.<br/>Tiểu tướng lớn mật nói câu này, xin đại nhân miễn trách.<br/>Vi Tiểu Bảo dậm chân la lên:<br/>- Ngươi nói năng úp úp mở mở, chẳng dứt khoát chút nào, không ra tuồng<br/>trượng phu khí khái. Chắc ngày thường ngươi phải nhiều lần quỳ gối trước giường<br/>của bà vợ. Nói lẹ đi! Nói lẹ đi!<br/>Hạ Quốc Tương mắng thầm trong bụng:<br/>- Tổ tông mười tám đời họ Vi nhà ngươi đều là giống súc sinh.<br/>Hắn đáp:<br/>- Chỉ sợ tên thích khách kia vạn nhất mà đúng là cung nữ hầu cận của công<br/>chúa, đại nhân trông thấy rồi đem đi, thì lúc vương gia đòi thích khách tiểu tướng<br/>lấy đâu ra người để phúc đáp. Như vậy là... hỏng bét!<br/>Vi Tiểu Bảo nghĩ thầm:<br/>- Thằng cha này thật là giảo quyệt! Hắn nói đón đầu để mình hứa lời không<br/>đem thích khách đi. Con mẹ nó! Thích khách là vợ mình, có lý đâu lại để bọn<br/>chúng khinh nhờn?<br/>Gã liền cười hỏi:<br/>- Ngươi đã quả quyết thích khách không phải là cung nữ của công chúa, sao<br/>lại còn e sợ?<br/>Hạ Quốc Tương đáp:<br/>- Đấy là tiểu tướng đoán như vậy, còn hư thực thế nào, quả tiểu tướng không<br/>hiểu rõ.<br/>Vi Tiểu Bảo hỏi:<br/>- Ngươi định không cho ta đem thích khách đi chăng?<br/>Hạ Quốc Tương đáp:<br/>- Tiểu tướng không dám. Xin đô thống đại nhân hãy tạm ngồi chờ ở sảnh<br/>đường một lát, tiểu tướng vào bẩm rõ với vương gia để việc này do vương gia và<br/>đô thống đại nhân định đoạt. Như thế thì dù vương gia có tức giận cũng không đổ<br/>trách nhiệm lên đầu tiểu tướng được.<br/>Vi Tiểu Bảo cười khành khạch lẩm bẩm:<br/>- Té ra ngươi chỉ sợ bố vợ đánh nát đit, nên tìm cách đổ trách nhiệm đi mà<br/>thôi.<br/>Gã liền gật đầu nói:<br/>- Được rồi! Ngươi vào bẩm đi!<br/>Rồi gã dặn:<br/>- Ta cho ngươi hay trước: Bất luận vương gia thức hay ngủ, ngươi cũng phải<br/>trả lời gấp vì ta phải về ngay tức khắc. Tấm thân của vương gia dĩ nhiên rất quan<br/>trọng, nhưng sự sống chết của công chúa cũng không phải chuyện tầm thường.<br/>Sau khi công chúa điện hạ bị thế tử của ngươi khinh nhờn, hiện tình không hiểu ra<br/>sao, nên ta phải về ngay để coi xem mới được.<br/>Sở dĩ Vi Tiểu Bảo phải căn dặn Hạ Quốc Tương như vậy là vì gã sợ Ngô Tam<br/>Quế li bì chưa tỉnh, hắn vào ngồi ỳ ra ở bên giường không dám kinh động.<br/>Hạ Quốc Tương khom lưng đáp:<br/>- Tiểu tướng chẳng khi nào dám để lỡ việc của đô thống đại nhân.<br/>Vi Tiểu Bảo hắng dặng một tiếng rồi nói:<br/>- Việc là việc của các vị, chứ nào phải việc của bản nhân?<br/>Hạ Quốc Tương vào phòng một lúc khá lâu. Vi Tiểu Bảo ngồi chờ bên ngoài<br/>nóng ruột cơ hồ không nhẫn nại được nữa. Gã bước lui rồi lại bước tới, nện mạnh<br/>gót chân xuống đất. Bỗng thấy Hạ Quốc Tương trở ra lên tiếng:<br/>- Vương gia vẫn chưa tỉnh hẳn nên tiểu tướng chỉ bẩm cáo cho vương gia hay<br/>mà không kịp chờ chỉ thị, phải lật đật trở ra chầu chực đại nhân đi thẩm vấn thích<br/>khách.<br/>Vi Tiểu Bảo gật đầu theo Hạ Quốc Tương đi vào phía trong.<br/>Hai người xuyên qua mấy dãy hành lang ra tới vườn hoa. Trong vườn, mấy<br/>chục tên gia tướng tay cầm binh khí đi lại tuần tiễu. Cách phòng vệ rất nghiêm<br/>mật.<br/>Hạ Quốc Tương dẫn Vi Tiểu Bảo đến trước một hòn non bộ. Hắn cầm mũi<br/>lệnh tiễn bằng vàng đưa cho tên võ quan canh gác ở đó và bảo:<br/>- Ta phụng khẩu dụ của vương gia đi chầu chực đô thống đại nhân vào thẩm<br/>vấn thích khách.<br/>Tên võ quan kia xem xét lệnh tiễn rồi khom lưng đáp:<br/>- Xin mời đô thống đại nhân và tổng binh đại nhân.<br/>Đoạn hắn nghiêng mình đứng tránh sang một bên.<br/>Hạ Quốc Tương lại nói:<br/>- Tiểu tướng xin dẫn đường.<br/>Rồi hắn chuồn vào cửa động trong núi non bộ.<br/>Vi Tiểu Bảo đi theo mới được mấy bước thì gặp khuôn cửa sắt lớn. Bên cửa<br/>có hai tên gia tướng canh giữ.<br/>Nguyên hòn non bộ này là cửa vào trong địa lao.<br/>Qua ba tầng cửa sắt nữa, đường đi mỗi lúc một xuống thấp dẫn tới trước một<br/>căn nhà nhỏ. Mặt trước căn nhà đặt những chấn song sắt lớn bằng cánh tay trẻ<br/>con.<br/>Phía trong song sắt, một thiếu nữ ngồi dưới đất, hai tay ôm đầu đang khóc<br/>thút thít.<br/>Trên tường đặt mấy ngọn đèn dầu, chiếu ra ánh sáng vàng khè.<br/>Vi Tiểu Bảo rảo bước tiến lại, hai tay vịn chấn song sắt. Gã chú ý nhìn thiếu<br/>nữ.<br/>Hạ Quốc Tương quát lên:<br/>- Đứng dậy! Đô thống đại nhân có điều hỏi ngươi đó.<br/>Thiếu nữ ngoảnh đầu nhìn ra, ánh đèn sôi rõ mặt cô.<br/>Vi Tiểu Bảo cùng thiếu nữ bốn mắt nhìn nhau, cùng bật tiếng la hoảng:<br/>- Ô hay!<br/>Thiếu nữ đứng dậy. Xiềng khoá chân tay cô phát ra những tiếng loảng xoảng.<br/>Cô ngập ngừng hỏi:<br/>- Tướng công⬢ tướng công đấy ư?...<br/>Vi Tiểu Bảo hỏi:<br/>- Sao... sao nàng lại ở đây?<br/>Cả hai người đều cực kỳ kinh dị. Vi Tiểu Bảo không ngờ thiếu nữ này chẳng<br/>phải là A Kha mà là tiểu quận chúa Mộc Kiếm Bình ở Mộc vương phủ.<br/>Gã định thần rồi quay ra hỏi Hạ Quốc Tương:<br/>- Tại sao lại đem y giam ở trong này?<br/>Hạ Quốc Tương hỏi lại:<br/>- Đại nhân quen mặt thích khách. Y... y đúng là cung nữ chầu hầu công chúa<br/>hay sao?<br/>Vi Tiểu Bảo không trả lời, hỏi lại:<br/>- Y... y là thích khách đã hành thích Ngô... hành thích vương gia phải không?<br/>Hạ Quốc Tương đáp:<br/>- Chính y đó! Cô gáii này thật là lớn mật, dám làm điều phạm thượng phản<br/>loạn. Xin đại nhân thẩm vấn cho ra người đã sai phái y.<br/>Vi Tiểu Bảo vững tâm được một chút, miệng lẩm bẩm:<br/>- Té ra mọi người đều hiểu lầm. Kẻ hành thích Ngô Tam Quế không phải là A<br/>Kha mà là tiểu quận chúa của Mộc gia. Phụ thân nàng bị Ngô Tam Quế gia hại,<br/>nàng ra tay hành thích hắn để trả thù cho phụ thân, chẳng có chi là lạ.<br/>Gã lại hỏi Hạ Quốc Tương:<br/>- Phải chăng y đã xưng danh là Ngọc Khả và là cung nữ hầu cận của công<br/>chúa.<br/>Hạ Quốc Tương đáp:<br/>- Bọn tiểu tướng sau khi bắt được y đã tra hỏi tính danh, lai lịch cùng nhân<br/>vật nào đã sai khiêế, nhưng y nhất định không chịu cung khai chi hết. Sau có<br/>người nhận ra y là cung nữ Ngọc Khả. Không hiểu có đúng vậy chăng? Xin đại nhân<br/>chỉ thị.<br/>Vi Tiểu Bảo bụng bảo dạ:<br/>- Tiểu quận chúa bị bắt, dĩ nhiên ta phải tìm cách cứu nàng.<br/>Gã liền nói:<br/>- Y đúng là cung nữ hầu cận của công chúa. Công chúa vốn rất yêu thương y.<br/>Gã nói rồi chớp mắt nhìn Mộc Kiếm Bình, lớn tiếng hỏi:<br/>- Ngươi thật là lớn mật! Sao dám cả gan hành thích Bình Tây vương. Ngươi<br/>không muốn sống nữa chăng? Kẻ nào xúi bẩy ngươi? Biết điều thì hãy cung xưng<br/>đúng sự thật đi, để khỏi chịu đau khổ về xác thịt.<br/>Mộc Kiếm Bình khẳng khái đáp:<br/>- Tên đại Hán gian Ngô Tam Quế nhận giặc làm cha, đem giang sơn nhà Đại<br/>Minh dâng cho quân Thát đát. Đã là người Hán ai mà chẳng muốn ăn tươi nuốt sống<br/>hắn. Đáng tiếc là ta chưa giết được tên gian tặc đó.<br/>Vi Tiểu Bảo giả vờ nổi lôi đình, quát mắng:<br/>- Con tiểu nha đầu kia! Sao dám thốt ra những lời vô pháp vô thiên như vậy?<br/>Mi ở trong hoàng cung đã lâu ngày mà không hiểu một chút luật lệ nào hết. Mau<br/>mau cung xưng ra: Ai là kẻ sai mi đến hành thích? Đồng đảng của mi còn những ai<br/>nữa?<br/>Mộc Kiếm Bình đáp:<br/>- Ngươi ở hoàng cung lâu hơn ta nhiều, nhưng đã biết những luật lệ gì? Hắn là<br/>đồng đảng và đã xúi bẩy ta.<br/>Cô vừa nói vừa trỏ vào Hạ Quốc Tương.<br/>Hạ Quốc Tương tức giận quát:<br/>- Con tiểu nha đầu kia! Sao mi dám nói nhăng nói càn?<br/>Vi Tiểu Bảo tiến lại một bước, giơ ngón tay cái bên mặt trỏ về phía sau ra<br/>hiệu cho tiểu quận chúa tiếp tục buộc tội Hạ Quốc Tương. Gã lấy thân hình che<br/>ngón tay, mà Hạ Quốc Tương đứng ở phía sau nên không trông thấy thủ thế cùng<br/>việc gã liếc mắt ra hiệu.<br/>Mộc Kiếm Bình hiểu ý, liền lớn tiếng:<br/>- Đúng là hắn xui ta hành thích Ngô Tam Quế. Hắn bảo Ngô Tam Quế là con<br/>người cực kỳ bại hoại xấu xa, ai cũng căm hận muốn đâm chết lão. Hắn dỗ dành ta<br/>sau khi đâm chết được Ngô Tam Quế hắn có thể... có thể...<br/>Cô không hiểu Hạ Quốc Tương địa vị thế nào, lại không thạo nghề nói dối,<br/>nên ấp úng mãi không nói tiếp được.<br/>Vi Tiểu Bảo liền hỏi:<br/>- Phải chăng y bảo có thể thăng quan phát tài và sau này không còn bị ai<br/>kiềm chế đánh mắng nữa?<br/>Mộc Kiếm Bình lại nói lớn:<br/>- Phải rồi! Hắn bảo Ngô Tam Quế thường đánh mắng hắn, lại đối đãi với hắn<br/>rất hung ác, nên trong lòng hắn căm tức vô cùng. Hắn muốn trừ bỏ Ngô Tam Quế<br/>từ lâu rồi, nhưng... nhưng hắn không đủ can đảm.<br/>Hạ Quốc Tương nghe cô nói mỗi lúc một thêm bực tức, quát mắng cô không<br/>ngớt, nhưng Mộc Kiếm Bình không lý gì đến hắn.<br/>Vi Tiểu Bảo cũng quát lên:<br/>- Con nha đầu kia! Ngươi phải coi chừng đừng có ăn nói tầm bậy. Ngươi có<br/>biết y là ai không? Y là nữ tế của Bình Tây vương tên gọi Hạ Quốc Tương, hiện<br/>làm tổng binh dưới trướng vương gia. Bình Tây vương tuy có lúc đánh mắng y, song<br/>đó chỉ là làm lợi cho y, nào phải chuyện thù hằn?<br/>Mộc Kiếm Bình nói:<br/>- Tên Hạ tổng binh này bảo ta hễ giết được Ngô Tam Quế thì hắn có thể lên<br/>làm Bình Tây vương. Hắn còn dỗ ngon dỗ ngọt ta bất luận hành thích có thành<br/>công hay không, hắn cũng buông tha ta, chứ không để ta đau khổ chút nào. Thế<br/>mà hắn lại giam cầm ta trong này.<br/>Đoạn cô lớn tiếng hỏi:<br/>- Hạ tổng binh! Bao giờ tổng binh mới buông tha ta?<br/>Hạ Quốc Tương bụng bảo dạ:<br/>- Nguyên con tiện nhân kia không nhận biết ta là ai, chính thằng lỏi này nói ra<br/>hết.");
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            settings.edit().putBoolean("my_first_time", false).commit();
        }
    }

    @Override
    public void makeRootFolderDone(File rootFolder) {
        mDisplayFolderPresenter.getAllFolder(rootFolder);
    }

    @Override
    public void getAllFolderDone(final ArrayList<String> folderNames) {
        mBinding.comicLoadProgressBar.setVisibility(View.GONE);
        mBinding.comicListView.setAdapter(
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, folderNames));
        mBinding.comicListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, SectionActivity.class);
                intent.putExtra("comicName", folderNames.get(position));
                startActivity(intent);
            }
        });
    }
}
