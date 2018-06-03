import {StackExchangeOwner} from "./StackExchangeOwner";
export class StackExchangeItem {
  /**
   * Теги вопроса
   */
  tags: string[];
  /**
   * Пользователь, задавший вопрос
   */
  owner: StackExchangeOwner;
  /**
   * Есть ли решение вопроса
   */
  is_answered: boolean;
  /**
   * Количество ответов на вопрос
   */
  answer_count: number;
  /**
   * Дата последней активности по вопросу
   */
  last_activity_date: number;
  /**
   * Дата создания вопроса
   */
  creation_date: number;
  /**
   * Дата последнего редактирования вопроса
   */
  last_edit_date: Date;
  /**
   * Идентификатор вопроса
   */
  question_id: number;
  /**
   * Ссылка на вопрос
   */
  link: string;
  /**
   * Тема вопроса
   */
  title: string;
}
