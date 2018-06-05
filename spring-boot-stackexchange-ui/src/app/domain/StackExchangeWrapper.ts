import {StackExchangeItem} from "./StackExchangeItem";

/**
 * Формат ответа
 */
export class StackExchangeWrapper {

  /**
   * Список найденных вопросов
   */
  items: StackExchangeItem[];
  /**
   * Есть ли еще данные по запросу
   */
  has_more: boolean;
  /**
   * Сообщение ошибки, если была ошибка
   */
  error_message: string;
}
