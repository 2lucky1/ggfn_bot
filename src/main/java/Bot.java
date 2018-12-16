import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    private int count = 0;
    private String helpMessage = "/myname@ggfn_bot - displays first name of the developer\n" +
            "/mylastname@ggfn_bot - displays last name of the developer\n" +
            "/myfullname@ggfn_bot - displays full name of the developer\n" +
            "/telljoke@ggfn_bot - tells a joke";

    public void onUpdateReceived(Update update) {
        String command = update.getMessage().getText();
        SendMessage message = new SendMessage();
        String joke;

        if (command.equals("/help")) {
            System.out.println(helpMessage);
            message.setText(helpMessage);
        } else if (command.equals("/myname@ggfn_bot")) {
            System.out.println(update.getMessage().getFrom().getFirstName());
            message.setText(update.getMessage().getFrom().getFirstName());
        } else if (command.equals("/mylastname@ggfn_bot")) {
            System.out.println(update.getMessage().getFrom().getLastName());
            message.setText(update.getMessage().getFrom().getLastName());
        } else if (command.equals("/myfullname@ggfn_bot")) {
            System.out.println(update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName());
            message.setText(update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName());
        } else if (command.equals("/telljoke@ggfn_bot")) {

            switch (count) {
                case 0:
                    joke = "Шутить вредно. Сам шути!";
                    break;
                case 1:
                    joke = "- Милая, поставь чайник на огонь и иди ко мне!\n" +
                            "- На большой огонь ставить?\n" +
                            "\n";
                    break;
                case 2:
                    joke = "Если вы хотите со мной разговаривать, товарищ солдат, то стойте и молчите!!!\n" +
                            "\n";
                    break;
                case 3:
                    joke = "- Как я переживаю за свою жену!\n" +
                            "- А что с ней?\n" +
                            "- С ней моя машина!\n" +
                            "\n";
                    break;
                case 4:
                    joke = "- А где моя сосиска?!\n" +
                            "- Кот сожрал!\n" +
                            "- Вот собака!\n" +
                            "\n";
                    break;
                case 5:
                    joke = "В мире так много разных денег, а люди не знают что мне подарить...\n" +
                            "\n";
                    break;
                case 6:
                    joke = "Как музыку не сортируй, а папку \"разное\" создать придется.";
                    break;
                default:
                    joke = "Я забыл все шутки";
            }

            count++;
            if (count > 6) {
                count = 0;
            }

            System.out.println(joke);
            message.setText(joke);
        }

        message.setChatId(update.getMessage().getChatId());

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    public String getBotUsername() {
        return "ggfn_bot";
    }

    public String getBotToken() {
        return "749876105:AAHsgq9VDTuHoVSSYzoUXE7DaiGP7FTyRws";
    }
}
