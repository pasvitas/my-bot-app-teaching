package ru.pasvitas.teaching.startteaching.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TelegramUpdateListener implements UpdatesListener {

	private final StudentsService studentsService;

	private final TelegramBot telegramBot;

	@Override
	public int process(List<Update> list) {
		for (Update update : list) {
			if (update.message().text().equals("/students")) {
				telegramBot.execute(new SendMessage(update.message().chat().id(), studentsService.getAllStudents(null, null).getFirst().getFirstName()));
			}
		}
		return UpdatesListener.CONFIRMED_UPDATES_ALL;
	}

	@EventListener(ApplicationReadyEvent.class)
	public void onReady() {
		telegramBot.setUpdatesListener(this);
	}
}
